function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick() {
        const inputElement = document.querySelector('#inputs textarea');
        const inputList = inputElement.value.slice(1, -1).split('","').map(str => str.replace(/["\[\]]/g, ''));
        const restaurants = {};
        for (const entry of inputList) {
            let [restaurant, workersData] = entry.split(' - ');
            if (!restaurants[restaurant]) {
                restaurants[restaurant] = [];
            }
            let workersArray = workersData.split(', ');
            for (let i = 0; i < workersArray.length; i++) {
                let worker = workersArray[i];
                let [name, salary] = worker.split(' ');
                restaurants[restaurant].push({ name, salary: Number(salary) });
            }
        }
        let bestRestaurantName = '';
        let bestAverageSalary = 0;
        for (let restaurant in restaurants) {
            let workers = restaurants[restaurant];
            let totalSalary = 0;
            for (let i = 0; i < workers.length; i++) {
                totalSalary += workers[i].salary;
            }
            let averageSalary = totalSalary / workers.length;
            if (averageSalary > bestAverageSalary) {
                bestAverageSalary = averageSalary;
                bestRestaurantName = restaurant;
            }
        }
        const bestRestaurantWorkers = restaurants[bestRestaurantName].sort((a, b) => b.salary - a.salary);
        let bestRestaurantTotalSalary = 0;
        for (let i = 0; i < bestRestaurantWorkers.length; i++) {
            bestRestaurantTotalSalary += bestRestaurantWorkers[i].salary;
        }
        const bestRestaurantAverageSalary = bestRestaurantTotalSalary / bestRestaurantWorkers.length;
        const bestRestaurantBestSalary = bestRestaurantWorkers[0].salary;
        const bestRestaurantOutput = `Name: ${bestRestaurantName} Average Salary: ${bestRestaurantAverageSalary.toFixed(2)} Best Salary: ${bestRestaurantBestSalary.toFixed(2)}`;
        const workersOutput = bestRestaurantWorkers.map(worker => `Name: ${worker.name} With Salary: ${worker.salary}`).join(' ');
        document.querySelector('#bestRestaurant p').textContent = bestRestaurantOutput;
        document.querySelector('#workers p').textContent = workersOutput;
    }
}