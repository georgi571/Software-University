function convertToObject(input) {
    let personInfo = JSON.parse(input);
    for (let key of Object.keys(personInfo)) {
        console.log(`${key}: ${personInfo[key]}`);
    }
}