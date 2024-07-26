function solve() {
    const textareaInputElement = document.querySelector('#exercise textarea:first-of-type');
    const textareaOutputElement = document.querySelector('#exercise textarea:last-of-type');
    const generateButtonElement = document.querySelector('#exercise button:first-of-type');
    const buyButtonElement = document.querySelector('#exercise button:last-of-type');
    const furnitureTBodyElement = document.querySelector('.table tbody');
    generateButtonElement.addEventListener('click', (event) => {
        const furnitures = JSON.parse(textareaInputElement.value);
        for (let furniture of furnitures) {
            const imgElement = document.createElement('img');
            imgElement.src = furniture.img;
            const imageTdElement = document.createElement('td');
            imageTdElement.appendChild(imgElement);
            const nameElement = document.createElement('p');
            nameElement.textContent = furniture.name;
            const nameTdElement = document.createElement('td');
            nameTdElement.appendChild(nameElement);
            const priceElement = document.createElement('p');
            priceElement.textContent = furniture.price;
            const priceTdElement = document.createElement('td');
            priceTdElement.appendChild(priceElement);
            const decorationElement = document.createElement('p');
            decorationElement.textContent = furniture.decFactor;
            const decorationTdElement = document.createElement('td');
            decorationTdElement.appendChild(decorationElement);
            const checkBoxElement = document.createElement('input');
            checkBoxElement.setAttribute('type', 'checkbox');
            const checkBoxTdElement = document.createElement('td');
            checkBoxTdElement.appendChild(checkBoxElement);
            const furnitureTrElement = document.createElement('tr');
            furnitureTrElement.appendChild(imageTdElement);
            furnitureTrElement.appendChild(nameTdElement);
            furnitureTrElement.appendChild(priceTdElement);
            furnitureTrElement.appendChild(decorationTdElement);
            furnitureTrElement.appendChild(checkBoxTdElement);
            furnitureTBodyElement.appendChild(furnitureTrElement);
        }
    })
    buyButtonElement.addEventListener('click', (event) => {
        let totalPrice = 0;
        let totalDecorationFactor = 0;
        let names =[];
        let markedChildren = 0;
        Array.from(furnitureTBodyElement.children)
            .forEach(furnitureTableRowElement => {
                const markInputElement = furnitureTableRowElement.querySelector('input[type=checkbox]');
                if (!markInputElement.checked) {
                    return;
                }
                const name = furnitureTableRowElement.children[1].textContent;
                const price = Number(furnitureTableRowElement.children[2].textContent);
                const decorationFactor = Number(furnitureTableRowElement.children[3].textContent);
                names.push(name);
                totalPrice += price;
                totalDecorationFactor += decorationFactor;
                markedChildren++;
            });
        const averageDecorationFactor = totalDecorationFactor / markedChildren;
        textareaOutputElement.textContent += `Bought furniture: ${names.join(', ')}\n`;
        textareaOutputElement.textContent += `Total price: ${totalPrice.toFixed(2)}\n`;
        textareaOutputElement.textContent += `Average decoration factor: ${averageDecorationFactor}`;
    });
}