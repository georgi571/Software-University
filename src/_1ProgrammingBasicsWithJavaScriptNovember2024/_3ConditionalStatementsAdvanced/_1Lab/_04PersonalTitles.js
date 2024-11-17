function personalTitles(age, gender) {
    let output = "";

    if (age >= 16) {
        if (gender === 'm') {
            output = "Mr.";
        } else if (gender === 'f') {
            output = "Ms.";
        }
    } else if (age < 16) {
        if (gender === 'm') {
            output = "Master";
        } else if (gender === 'f') {
            output = "Miss";
        }
    }

    console.log(`${output}`)
}