function validate() {
    const emailInputElement = document.querySelector('#email');
    const pattern = /^[a-z]+@[a-z]+.[a-z]+/
    emailInputElement.addEventListener('change', (event) => {
        if (!pattern.test(event.target.value)) {
            event.target.classList.add('error');
        } else {
            event.target.classList.remove('error');
        }
    });
}