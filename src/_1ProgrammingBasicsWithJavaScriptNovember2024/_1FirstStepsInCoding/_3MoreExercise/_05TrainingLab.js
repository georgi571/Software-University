function trainingLab(w, h) {
    const wInCm = w * 100;
    const hInCm = h * 100;
    const hMinusCorridor = hInCm - 100.00;
    const deskInRow = Math.floor(hMinusCorridor / 70);
    const rows = Math.floor(wInCm / 120);
    const numbersOfChairs = (deskInRow * rows) - 3;

    console.log(`${numbersOfChairs}`)
}