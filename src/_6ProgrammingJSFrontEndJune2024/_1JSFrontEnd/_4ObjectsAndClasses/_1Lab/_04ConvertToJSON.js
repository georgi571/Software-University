function convertToJSON(firstName, lastName, hairColor) {
    const personInfo = {name: firstName, lastName: lastName, hairColor: hairColor};
    const personInfoToJSON = JSON.stringify(personInfo);
    console.log(personInfoToJSON);
}