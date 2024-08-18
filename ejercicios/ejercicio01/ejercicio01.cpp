#include <iostream>

int sumaElementos(int arreglo[], int tamaño) {
    int suma = 0;
    for (int i = 0; i < tamaño; ++i) {
        suma += arreglo[i];
    }
    return suma;
}

int main() {
    int arreglo[] = {1, 2, 3, 4, 5};
    int tamaño = sizeof(arreglo) / sizeof(arreglo[0]);
    int resultado = sumaElementos(arreglo, tamaño);
    std::cout << "Suma: " << resultado << std::endl;
    return 0;
}
