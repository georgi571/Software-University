function solve(array) {
    let oddSum = 0;
    let evenSum = 0;
    for (let i = 0; i < array.length; i++) {
        if (array[i] % 2 === 0) {
            evenSum += array[i];
        } else {
            oddSum += array[i];
        }
    }
    let result = evenSum - oddSum;
    console.log(result);
}