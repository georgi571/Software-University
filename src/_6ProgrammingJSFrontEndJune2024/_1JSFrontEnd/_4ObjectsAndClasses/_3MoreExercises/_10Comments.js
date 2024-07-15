function comments(input) {
    let articlesComments = {};
    let users = [];
    let articles = [];
    for (let inputElement of input) {
        if (inputElement.startsWith('user ')) {
            users.push(inputElement.split(' ')[1]);
        } else if (inputElement.startsWith('article ')) {
            articles.push(inputElement.split(' ')[1]);
        } else {
            let userName = inputElement.split(' posts on ')[0];
            let articleName = inputElement.split(' posts on ')[1].split(': ')[0];
            let commentTitle = inputElement.split(' posts on ')[1].split(': ')[1].split(', ')[0];
            let commentContent = inputElement.split(' posts on ')[1].split(': ')[1].split(', ')[1];
            if (users.includes(userName) && articles.includes(articleName)) {
                if (!articlesComments[articleName]) {
                    articlesComments[articleName] = [];
                }
                articlesComments[articleName].push({
                    user: userName,
                    title: commentTitle,
                    content: commentContent
                });
            }
        }
    }
    let sortedArticles = Object.entries(articlesComments).sort((a, b) => b[1].length - a[1].length);
    for (let [articleName, articleComments] of sortedArticles) {
        console.log(`Comments on ${articleName}`);
        let sortedComments = articleComments.sort((a, b) => a.user.localeCompare(b.user));
        for (let comment of sortedComments) {
            console.log(`--- From user ${comment.user}: ${comment.title} - ${comment.content}`);
        }
    }
}