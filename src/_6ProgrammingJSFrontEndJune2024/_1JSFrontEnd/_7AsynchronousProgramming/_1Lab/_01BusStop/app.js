async function getInfo() {
    const stopId = document.getElementById('stopId').value;
    const stopNameDiv = document.getElementById('stopName');
    const busesUl = document.getElementById('buses');
    stopNameDiv.textContent = '';
    busesUl.innerHTML = '';

    try {
        const response = await fetch(`http://localhost:3030/jsonstore/bus/businfo/${stopId}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        stopNameDiv.textContent = data.name;
        for (const [busId, time] of Object.entries(data.buses)) {
            const li = document.createElement('li');
            li.textContent = `Bus ${busId} arrives in ${time} minutes`;
            busesUl.appendChild(li);
        }
    } catch (error) {
        stopNameDiv.textContent = 'Error';
    }
}