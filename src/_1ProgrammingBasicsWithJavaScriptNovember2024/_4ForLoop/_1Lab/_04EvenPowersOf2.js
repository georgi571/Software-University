function evenPowerOf2(number) {
    for (let i = 0; i <= number; i += 2) {
        const num = Math.pow(2, i);
        console.log(`${num}`);
    }
}