function encodeAndDecodeMessages() {
    const encodeButtonElement = document.querySelector('main div:nth-child(1) button');
    const encodeTextAreaElement = document.querySelector('main div:nth-child(1) textarea');
    const decodeButtonElement = document.querySelector('main div:nth-child(2) button');
    const decodeTextAreaElement = document.querySelector('main div:nth-child(2) textarea');
    encodeButtonElement.addEventListener('click', () => {
        let encodedMessage = '';
        for (let valueElement of encodeTextAreaElement.value) {
            encodedMessage += String.fromCharCode(valueElement.charCodeAt(0) + 1);
        }
        decodeTextAreaElement.value = encodedMessage;
        encodeTextAreaElement.value = '';
    })
    decodeButtonElement.addEventListener('click', () => {
        let decodedMessage = '';
        for (let valueElement of decodeTextAreaElement.value) {
            decodedMessage += String.fromCharCode(valueElement.charCodeAt(0) - 1);
        }
        decodeTextAreaElement.value = decodedMessage;
    });
}