function catalog(input) {
    let catalog = {};
    for (let inputElement of input) {
        const element = inputElement[0];
        if (catalog.hasOwnProperty(element)) {
            catalog[element].push(inputElement);
        } else {
            catalog[element] = [];
            catalog[element].push(inputElement);
        }
    }
    Object.keys(catalog).sort().forEach(key => {
        console.log(key)
        const values = catalog[key];
        values.sort((a, b) => a.localeCompare(b));
        values.forEach((value) => {
            const output = value.split(' : ')
            console.log(`  ${output[0]}: ${output[1]}`);
        });
    });
}