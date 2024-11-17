function numberInRange(number) {
    let output = "";

    if (number >= -100 && number <= 100 && number !== 0) {
        output = "Yes";
    } else {
        output = "No";
    }

    console.log(`${output}`)
}