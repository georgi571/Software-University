function attachEvents() {
    document.getElementById('submit').addEventListener('click', sendMessage);
    document.getElementById('refresh').addEventListener('click', refreshMessages);
    const baseUrl = 'http://localhost:3030/jsonstore/messenger';
    async function sendMessage() {
        const author = document.querySelector('input[name="author"]').value;
        const content = document.querySelector('input[name="content"]').value;
        if (author && content) {
            const message = {
                author: author,
                content: content,
            };
            try {
                const response = await fetch(baseUrl, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(message),
                });
                if (!response.ok) {
                    throw new Error(`Failed to post message: ${response.status} ${response.statusText}`);
                }
                author.value = '';
                content.value = '';
                refreshMessages();
            } catch (error) {
                console.error('Error posting message:', error);
            }
        } else {
            alert('Please enter both author and content!');
        }
    }
    async function refreshMessages() {
        try {
            const response = await fetch(baseUrl);
            if (!response.ok) {
                throw new Error(`Failed to fetch messages: ${response.status} ${response.statusText}`);
            }
            const data = await response.json();
            const messagesArea = document.getElementById('messages');
            let messagesArr = [];
            for (let key in data) {
                const message = data[key];
                messagesArr.push(`${message.author}: ${message.content}`);
            }
            messagesArea.value = messagesArr.join('\n');
        } catch (error) {
            console.error('Error fetching messages:', error);
        }
    }
}

attachEvents();