//@ts-check

import { $ } from "bun";

const bsUsername = process.env.BS_USERNAME;
const bsKey = process.env.BS_KEY;

if (!(bsKey && bsUsername)) {
    throw new Error("BS_USERNAME and/or BS_KEY is undefined! Please, set correct values in .env file");
}

const pathToAppApk = await $`realpath app/build/outputs/apk/debug/app-debug.apk`.quiet();
const pathToAppTestsApk = await $`realpath app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk`.quiet();
const pathToAppApkResolved = pathToAppApk.stdout.toString();
const pathToAppTestsApkResolved = pathToAppTestsApk.stdout.toString();

/**
 * 
 * @param {string} username 
 * @param {string} key 
 * @param {string} fullPath full path to the app in file system
 * @returns `curl` command to upload app to BS 
 */
const uploadApp = async (username, key, fullPath) => await $`curl -u "${username}:${key}" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/app" \
-F "file=@${fullPath}"`;

/**
 * 
 * @param {*} username 
 * @param {*} key 
 * @param {*} fullPath 
 * @returns 
 */
const uploadTestApp = async (username, key, fullPath) => await $`curl -u "${username}:${key}" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/test-suite" \
-F "file=@${fullPath}"`;

/**
 * 
 * @param {*} username 
 * @param {*} key 
 * @param {*} appId 
 * @param {*} testSuiteId
 * @param {*} deviceName 
 * @returns 
 */
const triggerTests = async (username, key, appId, testSuiteId, deviceName = 'Samsung Galaxy S23-13.0') => {
    console.log(`curl -u "${username}:${key}" \
    -X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
    -d '{"app": "${appId}", "testSuite": "${testSuiteId}", "devices": ["${deviceName}"]}' \
    -H "Content-Type: application/json"`)
    
    return await $`curl -u "${username}:${key}" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
-d '{"app": "${appId}", "testSuite": "${testSuiteId}", "devices": ["${deviceName}"]}' \
-H "Content-Type: application/json"`};

/**
 * 
 * @param {(...args: string[])=> Promise<import("bun").ShellOutput>} asyncFn 
 * @param  {...any} args 
 */
const runBsCommand = async (asyncFn, ...args) => {
    try {
        const result = await asyncFn(...args);
        const resultParsed = JSON.parse(result.stdout.toString());

        console.log("RESULT PARSED")
        console.log(resultParsed);

        if (!!(resultParsed?.error)) {
            console.log(resultParsed);
            throw new Error("There is an error occurred during BrowserStack API invocation")
        }

        console.log(resultParsed);

        return resultParsed;
    } catch (error) {
        console.log(error);
        process.exit(1);
    }
}

const envVar = process.env.TEST_VAR;

// console.log(envVar);
console.log(pathToAppApkResolved);
console.log(pathToAppTestsApkResolved);

// const uploadAppResponse = await uploadApp(bsUsername, bsKey, pathToAppApkResolved)
// console.log(JSON.parse(uploadAppResponse.stdout.toString()));

const uploadAppRes = await runBsCommand(uploadApp, bsUsername, bsKey, pathToAppApkResolved);
const uploadTestAppRes = await runBsCommand(uploadTestApp, bsUsername, bsKey, pathToAppTestsApkResolved);

console.log(uploadAppRes);
console.log(uploadTestAppRes);

const appUrl = uploadAppRes["app_url"];
const testSuiteUrl = uploadTestAppRes["test_suite_url"];

console.log(appUrl);
console.log(testSuiteUrl);

console.log("sleep for 5000 ms")
await Bun.sleep(10000);

await runBsCommand(triggerTests, bsUsername, bsKey, appUrl, testSuiteUrl);

