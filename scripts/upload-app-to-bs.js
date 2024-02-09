//@ts-check

import { $ } from "bun";

const bsUsername = process.env.BS_USERNAME;
const bsKey = process.env.BS_KEY;

if(!(bsKey && bsUsername)){
    throw new Error("BS_USERNAME and/or BS_KEY is undefined! Please, set correct values in .env file");
}

const pathToAppApk = await $`realpath app/build/outputs/apk/debug/app-debug.apk`;
const pathToAppTestsApk = await $`realpath app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk`

/**
 * 
 * @param {string} username 
 * @param {string} key 
 * @param {string} fullPath full path to the app in file system
 * @returns `curl` command to upload app to BS 
 */
const uploadApp = (username, key, fullPath) => `curl -u "${username}:${key}" \
> -X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/app" \
> -F "file=@${fullPath}"`;

const envVar = process.env.TEST_VAR;

console.log(envVar);
console.log(pathToAppApk.stdout.toString());
console.log(pathToAppTestsApk.stdout.toString());


