function solve() {
    const addProductButtonElements = document.querySelectorAll('button.add-product');
    const textAreaElement = document.querySelector('textarea');
    const checkOutElement = document.querySelector('button.checkout');
    let totalPrice = 0;
    const uniqueProduct = {};
    for (let addProductButtonElement of addProductButtonElements) {
        const productElement = addProductButtonElement.parentElement.parentElement;
        addProductButtonElement.addEventListener('click', () => {
            const title = productElement.querySelector('.product-title').textContent;
            const price = Number(productElement.querySelector('.product-line-price').textContent);
            totalPrice += price;
            uniqueProduct[title] = true;
            textAreaElement.textContent += `Added ${title} for ${price.toFixed(2)} to the cart.\n`
        });
    }
    checkOutElement.addEventListener('click', (event) => {
        Array.from(addProductButtonElements).forEach(buttonElement => buttonElement.setAttribute('disabled', 'disabled'));
        event.target.setAttribute('disabled', 'disabled');
        const list = Object.keys(uniqueProduct).join(', ');
        textAreaElement.textContent += `You bought ${list} for ${totalPrice.toFixed(2)}.`;
    });
}