function solve(fruit, grams, price) {
    const weight = grams / 1000;
    const sum = weight * price;
    console.log(`I need $${sum.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${fruit}.`);
}