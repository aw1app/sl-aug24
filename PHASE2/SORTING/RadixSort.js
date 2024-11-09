function radixSort(arr) {
    const result = [...arr];
    const radixArray = Array.from({ length: 10 }, () => []);

    //console.log(radixArray);

    const maxVal = Math.max(...result);
    let exp = 1;

    while (Math.floor(maxVal / exp) > 0) {
        // Distribute numbers to buckets
        for (let i = result.length - 1; i >= 0; i--) {
            const val = result[i];
            const radixIndex = Math.floor((val / exp) % 10);
            radixArray[radixIndex].push(val);
        }
        //console.log(radixArray);

        // Clear result array
        result.length = 0;

        // Collect numbers from buckets
        for (const bucket of radixArray) {
            while (bucket.length > 0) {
                result.push(bucket.pop());
            }
        }

        exp *= 10;
    }

    return result;
}

// Example usage
const myArray = [170, 45, 75, 90, 802, 24, 2, 66];
console.log("Original array:", myArray);

const sortedArray2 = radixSort(myArray);
console.log("Sorted array (idiomatic):", sortedArray2);