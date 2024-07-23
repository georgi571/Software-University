function create(words) {
   const contentElement = document.querySelector('#content');
   for (let word of words) {
      const divElement = document.createElement('div');
      const paragraphElement = document.createElement('p');
      paragraphElement.textContent = word;
      paragraphElement.style.display = 'none';
      divElement.appendChild(paragraphElement);
      divElement.addEventListener('click', () => {
         paragraphElement.style.display = 'block';
      })
      contentElement.appendChild(divElement);
   }
}