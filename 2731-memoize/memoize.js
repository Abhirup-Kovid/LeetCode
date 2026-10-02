/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    let callCount = 0;

    const memoizedFn = function(...args) {
        const key = JSON.stringify(args); // unique key for arguments
        if (cache.has(key)) {
            return cache.get(key);
        }
        const result = fn(...args);
        cache.set(key, result);
        callCount++;
        return result;
    };

    memoizedFn.getCallCount = () => callCount;

    return memoizedFn;
}

// Example functions
const sum = (a, b) => a + b;
const fib = (n) => (n <= 1 ? 1 : fib(n - 1) + fib(n - 2));
const factorial = (n) => (n <= 1 ? 1 : factorial(n - 1) * n);

// Usage
const memoizedSum = memoize(sum);
console.log(memoizedSum(2, 2)); // 4, sum() called
console.log(memoizedSum(2, 2)); // 4, cached
console.log(memoizedSum.getCallCount()); // 1
console.log(memoizedSum(1, 2)); // 3, sum() called
console.log(memoizedSum.getCallCount()); // 2
