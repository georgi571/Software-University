function order(product, quantity) {
    let output = getProductPrice(product) * quantity;
    console.log(output.toFixed(2));

    function getProductPrice(product) {
        if (product === 'coffee') {
            return 1.50;
        } else if (product === 'water') {
            return 1.00;
        } else if (product === 'coke') {
            return 1.40;
        } else if (product === 'snacks') {
            return 2.00;
        }
    }
}