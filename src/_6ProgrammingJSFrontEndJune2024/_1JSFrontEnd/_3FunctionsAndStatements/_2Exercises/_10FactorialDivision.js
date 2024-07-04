function divideFactorials(num1, num2) {
    let factorial1 = factorial(num1);
    let factorial2 = factorial(num2);
    let divisionResult = factorial1 / factorial2;
    console.log(divisionResult.toFixed(2));

    function factorial(n) {
        if (n === 0 || n === 1) {
            return 1;
        }
        let result = 1;
        for (let i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}