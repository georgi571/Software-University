function trainingLab(w, h) {
    let wInCm = w * 100;
    let hInCm = h * 100;
    let hMinusCorridor = hInCm - 100.00;
    let deskInRow = Math.floor(hMinusCorridor / 70);
    let rows = Math.floor(wInCm / 120);
    let numbersOfChairs = (deskInRow * rows) - 3;
    console.log(`${numbersOfChairs}`)
}