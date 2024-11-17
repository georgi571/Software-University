function invalidNumber(number) {
    let output = "";
    if ((number < 100 || number > 200) && number !== 0) {
        output = "invalid";
    }

    console.log(`${output}`)
}