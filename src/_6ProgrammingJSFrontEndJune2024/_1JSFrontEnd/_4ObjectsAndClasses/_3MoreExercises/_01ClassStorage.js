class Storage {
    capacity;
    storage = [];
    totalCost = 0;

    constructor(capacity) {
        this.capacity = capacity;
    }

    addProduct(product) {
        const productToAdd = {
            name: product.name,
            price: product.price,
            quantity: product.quantity,
        }
        this.storage.push(productToAdd);
        this.capacity -= product.quantity;
        this.totalCost += product.price * product.quantity;
    }

    getProducts() {
        return this.storage.map(product => JSON.stringify(product)).join('\n');
    }
}

