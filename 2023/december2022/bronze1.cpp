#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int N;
    std::cin >> N;

    std::vector<int> array(N); 

    for (int i=0; i<N; i++) {
        std::cin >> array[i];
    }

    sort(array.begin(), array.end(), std::greater<int>());

    // std::cout << "Array elements are: "; 
    // for (int i=0; i<N; i++) {
    //     std::cout << array[i] << " ";
    // }
    // std::cout << std::endl;

    int max_revenue = 0;
    int best_tuition;

    for (int i=0; i<N; i++) {
        int revenue = (i+1) * array[i]; 

        if (revenue > max_revenue) {
            max_revenue = revenue;
            best_tuition = array[i];
        }
    }

    std::cout << max_revenue << " " << best_tuition;

}

