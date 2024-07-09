function storeProvision(firstItems, secondItems) {
    let store = {};
    for (let i = 0; i < firstItems.length; i += 2) {
        store[firstItems[i]] = Number(firstItems[i + 1]);
    }
    for (let i = 0; i < secondItems.length; i += 2) {
        if (store[secondItems[i]]) {
            store[secondItems[i]] = Number(secondItems[i + 1]) + store[secondItems[i]];
        } else {
            store[secondItems[i]] = Number(secondItems[i + 1]);
        }
    }
    for (let product in store) {
        console.log(`${product} -> ${store[product]}`);
    }
}