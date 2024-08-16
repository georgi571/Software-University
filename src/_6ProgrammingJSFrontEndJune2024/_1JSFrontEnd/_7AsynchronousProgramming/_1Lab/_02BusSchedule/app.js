function solve() {

    document.addEventListener("DOMContentLoaded", () => {
        const infoBox = document.querySelector("#info .info");
        const departButton = document.getElementById("depart");
        const arriveButton = document.getElementById("arrive");

        let currentStopId = "depot";
        let nextStopName = "";

        async function fetchStopData(stopId) {
            try {
                const response = await fetch(`http://localhost:3030/jsonstore/bus/schedule/${stopId}`);
                if (!response.ok) {
                    throw new Error("Failed to fetch stop data");
                }
                return await response.json();
            } catch (error) {
                infoBox.textContent = "Error";
                departButton.disabled = true;
                arriveButton.disabled = true;
                console.error("Error fetching data:", error);
            }
        }

        function depart() {
            fetchStopData(currentStopId).then(data => {
                if (data) {
                    nextStopName = data.name;
                    currentStopId = data.next;
                    infoBox.textContent = `Next stop ${nextStopName}`;
                    departButton.disabled = true;
                    arriveButton.disabled = false;
                }
            });
        }

        function arrive() {
            infoBox.textContent = `Arriving at ${nextStopName}`;
            departButton.disabled = false;
            arriveButton.disabled = true;
        }

        departButton.addEventListener("click", depart);
        arriveButton.addEventListener("click", arrive);
    });
    return {
        depart,
        arrive
    };
}

let result = solve();