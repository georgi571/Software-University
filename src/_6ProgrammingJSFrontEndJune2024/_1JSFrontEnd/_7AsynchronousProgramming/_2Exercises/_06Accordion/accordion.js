function solution() {
    document.addEventListener('DOMContentLoaded', () => {
        const mainSection = document.getElementById('main');

        fetch('http://localhost:3030/jsonstore/advanced/articles/list')
            .then(response => response.json())
            .then(data => {
                data.forEach(article => {
                    const accordionDiv = document.createElement('div');
                    accordionDiv.classList.add('accordion');
                    const headDiv = document.createElement('div');
                    headDiv.classList.add('head');
                    const titleSpan = document.createElement('span');
                    titleSpan.textContent = article.title;
                    const button = document.createElement('button');
                    button.classList.add('button');
                    button.textContent = 'More';
                    button.setAttribute('data-id', article._id);
                    headDiv.appendChild(titleSpan);
                    headDiv.appendChild(button);
                    const extraDiv = document.createElement('div');
                    extraDiv.classList.add('extra');
                    extraDiv.style.display = 'none';
                    accordionDiv.appendChild(headDiv);
                    accordionDiv.appendChild(extraDiv);
                    mainSection.appendChild(accordionDiv);
                    button.addEventListener('click', () => {
                        const extraContent = extraDiv.querySelector('p');
                        if (extraContent) {
                            if (extraDiv.style.display === 'none') {
                                extraDiv.style.display = 'block';
                                button.textContent = 'Less';
                            } else {
                                extraDiv.style.display = 'none';
                                button.textContent = 'More';
                            }
                        } else {
                            fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${article._id}`)
                                .then(response => response.json())
                                .then(details => {
                                    const contentParagraph = document.createElement('p');
                                    contentParagraph.textContent = details.content;

                                    extraDiv.appendChild(contentParagraph);
                                    extraDiv.style.display = 'block';
                                    button.textContent = 'Less';
                                });
                        }
                    });
                });
            })
            .catch(error => console.error('Error fetching articles:', error));
    });

}

solution();