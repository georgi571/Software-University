function toggle() {
    const buttonElement = document.querySelector('.head span.button');
    const extraInformationElement = document.querySelector('#extra');

    if (buttonElement.textContent === 'More') {
        extraInformationElement.style.display = 'block';
        buttonElement.textContent = 'Less';
    } else {
        extraInformationElement.style.display = 'none';
        buttonElement.textContent = 'More';
    }
}