function solve(number) {
    let sum = 0;
    while (number > 0) {
        sum += number % 10;
        number = Math.trunc(number / 10);
    }
    console.log(sum)
}