function fruitOrVegetables(product) {
    let output = "";
    if (product === "banana" || product === "apple" || product === "kiwi" || product === "cherry" || product === "lemon" || product === "grapes") {
        output = "fruit";
    } else if (product === "tomato" || product === "cucumber" || product === "pepper" || product === "carrot") {
        output = "vegetable";
    } else {
        output = "unknown";
    }

    console.log(`${output}`)
}