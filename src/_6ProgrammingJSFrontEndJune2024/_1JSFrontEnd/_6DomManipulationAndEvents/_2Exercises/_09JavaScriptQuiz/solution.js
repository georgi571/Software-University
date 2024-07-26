function solve() {
    const quizSectionsElements = document.querySelectorAll('section');
    const resultsSectionElement = document.getElementById('results');
    const resultsTitleElement = resultsSectionElement.querySelector('h1');
    const correctAnswers = [
        'onclick',
        'JSON.stringify()',
        'A programming API for HTML and XML documents'
    ];
    let rightAnswers = 0;
    quizSectionsElements.forEach((section, index) => {
        const answers = section.querySelectorAll('.quiz-answer');
        answers.forEach(answer => {
            answer.addEventListener('click', () => {
                const answerText = answer.querySelector('.answer-text').innerText;
                if (answerText === correctAnswers[index]) {
                    rightAnswers++;
                }
                section.style.display = 'none';
                if (index < quizSectionsElements.length - 1) {
                    quizSectionsElements[index + 1].style.display = 'block';
                } else {
                    resultsSectionElement.style.display = 'block';
                    if (rightAnswers === correctAnswers.length) {
                        resultsTitleElement.innerText = 'You are recognized as top JavaScript fan!';
                    } else {
                        resultsTitleElement.innerText = `You have ${rightAnswers} right answers`;
                    }
                }
            });
        });
    });
}
