function lockedProfile() {
    const BASE_URL = 'http://localhost:3030/jsonstore/advanced/profiles';
    const mainSection = document.getElementById('main');

    function createProfileCard(dataKey, num) {
        const profileDiv = document.createElement('div');
        profileDiv.className = 'profile';

        const imgEle = document.createElement('img');
        imgEle.src = './iconProfile2.png';
        imgEle.className = 'userIcon';
        profileDiv.appendChild(imgEle);

        const lockLabel = document.createElement('label');
        lockLabel.textContent = 'Lock';
        profileDiv.appendChild(lockLabel);

        const inputLock = document.createElement('input');
        inputLock.type = 'radio';
        inputLock.name = `user${num}Locked`;
        inputLock.value = 'lock';
        inputLock.checked = true;
        profileDiv.appendChild(inputLock);

        const unlockLabel = document.createElement('label');
        unlockLabel.textContent = 'Unlock';
        profileDiv.appendChild(unlockLabel);

        const inputUnlock = document.createElement('input');
        inputUnlock.type = 'radio';
        inputUnlock.name = `user${num}Locked`;
        inputUnlock.value = 'unlock';
        profileDiv.appendChild(inputUnlock);

        const brEle = document.createElement('br');
        profileDiv.appendChild(brEle);

        const hr1 = document.createElement('hr');
        profileDiv.appendChild(hr1);

        const userLabel = document.createElement('label');
        userLabel.textContent = 'Username';
        profileDiv.appendChild(userLabel);

        const inputUserName = document.createElement('input');
        inputUserName.type = 'text';
        inputUserName.name = `user${num}Username`;
        inputUserName.value = dataKey.username;
        inputUserName.setAttribute('disabled', 'true');
        inputUserName.setAttribute('readonly', 'true');
        profileDiv.appendChild(inputUserName);

        const userDiv = document.createElement('div');
        userDiv.className = 'hiddenInfo';

        const hr2 = document.createElement('hr');
        userDiv.appendChild(hr2);

        const emailLabel = document.createElement('label');
        emailLabel.textContent = 'Email:';
        userDiv.appendChild(emailLabel);

        const inputEmail = document.createElement('input');
        inputEmail.type = 'email';
        inputEmail.name = `user${num}Email`;
        inputEmail.value = dataKey.email;
        inputEmail.setAttribute('disabled', 'true');
        inputEmail.setAttribute('readonly', 'true');
        userDiv.appendChild(inputEmail);

        const ageLabel = document.createElement('label');
        ageLabel.textContent = 'Age:';
        userDiv.appendChild(ageLabel);

        const inputAge = document.createElement('input');
        inputAge.type = 'email';
        inputAge.name = `user${num}Age`;
        inputAge.value = dataKey.age;
        inputAge.setAttribute('disabled', 'true');
        inputAge.setAttribute('readonly', 'true');
        userDiv.appendChild(inputAge);

        profileDiv.appendChild(userDiv);

        const buttonEle = document.createElement('button');
        buttonEle.textContent = 'Show more';
        profileDiv.appendChild(buttonEle);

        buttonEle.addEventListener('click', function (e) {
            if (inputUnlock.checked) {
                if (buttonEle.textContent === 'Show more') {
                    userDiv.style.display = 'block';
                    buttonEle.textContent = 'Hide it';
                } else {
                    userDiv.style.display = 'none';
                    buttonEle.textContent = 'Show more';
                }
            }
        });

        return profileDiv;
    }

    async function createProfiles() {
        try {
            const response = await fetch(BASE_URL);
            if (!response.ok) {
                throw new Error('Failed to fetch profiles');
            }
            const data = await response.json();
            mainSection.innerHTML = '';

            let count = 0;
            for (const key in data) {
                count += 1;
                const profileCard = createProfileCard(data[key], count);
                mainSection.appendChild(profileCard);
            }
        } catch (error) {
            console.error('Error fetching profiles:', error);
        }
    }
    createProfiles();
}

lockedProfile();