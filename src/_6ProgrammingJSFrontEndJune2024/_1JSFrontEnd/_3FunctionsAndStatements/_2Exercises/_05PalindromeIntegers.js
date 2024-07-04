function palindromeIntegers(numbers) {
    numbers.forEach(number => {
        let numberToText = number.toString().split('');
        let output = true;
        for (let i = 0; i < numberToText.length/2; i++) {
            if (numberToText[i] !== numberToText[numberToText.length - i - 1]) {
                output = false;
                break;
            }
        }
        console.log(output);
    })
}