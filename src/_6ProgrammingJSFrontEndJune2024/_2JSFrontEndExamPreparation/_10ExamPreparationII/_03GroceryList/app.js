function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/grocery';

    const productElement = document.querySelector('#product');
    const countElement = document.querySelector('#count');
    const priceElement = document.querySelector('#price');

    const loadProductsButtonElements = document.querySelector('#load-product');
    const addProductButtonElements = document.querySelector('#add-product');
    const updateProductButtonElements = document.querySelector('#update-product');
    const tableListElements = document.querySelector('#tbody')
    const tableElements = document.querySelector('table')

    loadProductsButtonElements.addEventListener('click', loadProducts);
    addProductButtonElements.addEventListener('click', addProduct);
    updateProductButtonElements.addEventListener('click', updateProduct);

    async function loadProducts() {
        event.preventDefault();
        tableListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const products = Object.values(result);
        const productElements = products.map(product => createProductsElement(product.product, product.count, product.price, product._id));
        tableListElements.append(...productElements);
    }

    async function addProduct() {
        event.preventDefault();
        const product = productElement.value;
        const count = countElement.value;
        const price = priceElement.value;

        clearInputs();

        const response = await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({product: product, count: count, price: price}),
        });

        const newProduct = await response.json();
        const newProductElement = createProductsElement(newProduct.product, newProduct.count, newProduct.price, newProduct._id);
        tableListElements.appendChild(newProductElement);

        await loadProducts();
    }

    async function updateProduct() {
        event.preventDefault();
        const productID = tableElements.getAttribute('data-product-id');
        const product = productElement.value;
        const count = countElement.value;
        const price = priceElement.value;

        await clearInputs();

        await fetch(`${BASE_URL}/${productID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({product: product, count: count, price: price, _id: productID}),
        });

        await loadProducts();

        updateProductButtonElements.disabled = true;
        addProductButtonElements.disabled = false;

        tableElements.removeAttribute('data-product-id');
    }

    function createProductsElement(product, count, price, productID) {
        const tableRowElement = document.createElement('tr');

        const tableColumnNameElement = document.createElement('td');
        tableColumnNameElement.setAttribute('class', 'name');
        tableColumnNameElement.textContent = product;

        const tableColumnCountElement = document.createElement('td');
        tableColumnCountElement.setAttribute('class', 'count-product');
        tableColumnCountElement.textContent = count;

        const tableColumnPriceElement = document.createElement('td');
        tableColumnPriceElement.setAttribute('class', 'product-price');
        tableColumnPriceElement.textContent = price;

        const tableColumnButtonsElement = document.createElement('td');
        tableColumnButtonsElement.setAttribute('class', 'btn');

        const buttonUpdateElement = document.createElement('button');
        buttonUpdateElement.setAttribute('class', 'update');
        buttonUpdateElement.textContent = 'Update';

        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete');
        buttonDeleteElement.textContent = 'Delete';

        tableColumnButtonsElement.appendChild(buttonUpdateElement);
        tableColumnButtonsElement.appendChild(buttonDeleteElement);


        tableRowElement.appendChild(tableColumnNameElement);
        tableRowElement.appendChild(tableColumnCountElement);
        tableRowElement.appendChild(tableColumnPriceElement);
        tableRowElement.appendChild(tableColumnButtonsElement);

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonUpdateElement.addEventListener('click', () => {
            productElement.value = product;
            countElement.value = count;
            priceElement.value = price;
            updateProductButtonElements.disabled = false;
            addProductButtonElements.disabled = true;
            tableElements.setAttribute('data-product-id', productID);
        })

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${productID}`, {
                method: 'DELETE',
            });

            tableRowElement.remove()

            await loadProducts();
        })


        return tableRowElement;
    }

    function clearInputs() {
        productElement.value = '';
        countElement.value = '';
        priceElement.value = '';
    }
}

attachEvents();