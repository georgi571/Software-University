function sumPrimeNonPrime(input) {
    let command = input[0];

    let sumOfPrimeNumbers = 0;
    let sumOfNonPrimeNumbers = 0;

    let index = 1;
    while (command !== "stop") {
        let number = Number(command);
        let isPrime = true;

        if (number < 0) {
            console.log(`Number is negative.`);
            command = input[index++];
            continue;
        }

        for (let i = 2; i < number; i++) {
            if (number % i === 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            sumOfPrimeNumbers += number;
        } else {
            sumOfNonPrimeNumbers += number;
        }

        command = input[index++];
    }

    console.log(`Sum of all prime numbers is: ${sumOfPrimeNumbers}`);
    console.log(`Sum of all non prime numbers is: ${sumOfNonPrimeNumbers}`);
}