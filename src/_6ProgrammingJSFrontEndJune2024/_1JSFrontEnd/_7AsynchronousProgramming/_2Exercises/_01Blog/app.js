function attachEvents() {
    document.addEventListener('DOMContentLoaded', () => {
        const btnLoadPosts = document.getElementById('btnLoadPosts');
        const btnViewPost = document.getElementById('btnViewPost');
        const postsSelect = document.getElementById('posts');
        const postTitle = document.getElementById('post-title');
        const postBody = document.getElementById('post-body');
        const postComments = document.getElementById('post-comments');

        btnLoadPosts.addEventListener('click', async () => {
            try {
                const response = await fetch('http://localhost:3030/jsonstore/blog/posts');
                const postsData = await response.json();
                postsSelect.innerHTML = '';
                Object.entries(postsData).forEach(([key, post]) => {
                    const option = document.createElement('option');
                    option.value = key;
                    option.textContent = post.title;
                    postsSelect.appendChild(option);
                });
            } catch (error) {
                console.error('Error loading posts:', error);
            }
        });

        btnViewPost.addEventListener('click', async () => {
            try {
                const selectedPostId = postsSelect.value;
                const postsResponse = await fetch('http://localhost:3030/jsonstore/blog/posts');
                const postsData = await postsResponse.json();
                const selectedPost = postsData[selectedPostId];
                postTitle.textContent = selectedPost.title;
                postBody.textContent = selectedPost.body;
                const commentsResponse = await fetch('http://localhost:3030/jsonstore/blog/comments');
                const commentsData = await commentsResponse.json();
                const postRelatedComments = Object.values(commentsData).filter(comment => comment.postId === selectedPostId);
                postComments.innerHTML = '';
                postRelatedComments.forEach(comment => {
                    const li = document.createElement('li');
                    li.textContent = comment.text;
                    postComments.appendChild(li);
                });
            } catch (error) {
                console.error('Error viewing post:', error);
            }
        });
    });
}

attachEvents();