function browserHistory(inputInfo, inputArray) {
    let browserName = inputInfo['Browser Name'];
    let openTabs = inputInfo['Open Tabs'];
    let closedTabs = inputInfo['Recently Closed'];
    let browserLogs = inputInfo['Browser Logs'];
    for (let inputArrayElement of inputArray) {
        const operation = inputArrayElement.split(' ')[0];
        if (operation === 'Open') {
            openTabs.push(inputArrayElement.split(' ')[1]);
            browserLogs.push(inputArrayElement);
        } else if (operation === 'Close') {
            if (openTabs.some(tab => tab === inputArrayElement.split(' ')[1])) {
                openTabs = openTabs.filter(tab => tab !== inputArrayElement.split(' ')[1]);
                closedTabs.push(inputArrayElement.split(' ')[1]);
                browserLogs.push(inputArrayElement);
            }
        } else if (operation === 'Clear') {
            openTabs = [];
            closedTabs = [];
            browserLogs = [];
        }
    }
    console.log(`${browserName}`);
    console.log(`Open Tabs: ${openTabs.join(', ')}`);
    console.log(`Recently Closed: ${closedTabs.join(', ')}`);
    console.log(`Browser Logs: ${browserLogs.join(', ')}`);
}