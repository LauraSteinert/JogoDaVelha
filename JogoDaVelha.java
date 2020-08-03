
/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
    0 - Jogo não iniciado: o tabuleiro está 'vazio', isto é sem peças X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as peças X) é o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as peças O) é o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estão preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo já iniciado e em andamento: nenhuma das alternativas anteriores.
	
*/

public class JogoDaVelha {
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	/*
		Determina o status de uma partida de Jogo da Velha
		
		Entrada:
			tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha
			
		Saída:
			um inteiro contendo o status da partida (valores válidos de zero a quatro)
	*/
	static int verificaStatus(char[][] tabuleiro) {
		int status = -1;
		
		//Variáveis para vitória de X, vitória de Y e para a quantidade de espaços vazios no jogo.

		boolean vitoriaX = false;
		boolean vitoriaY = false;
		int quantidadeVazios = 0;
		

		// Para percorrer a matriz, com i como linha e j como coluna.

		for(int i = 0; i<tabuleiro.length; i++){
			for(int j=0; j<tabuleiro[i].length;j++){

		//Condições para averiguar a situação do jogo
			
			//Caso exista três X seguidos em coluna ou em linha, ou tenha três X nas diagonais

				//Na linha, com i como qualquer linha e j como a localização na coluna 

				if(tabuleiro[i][0] == pecaX &&
				tabuleiro[i][1] == pecaX && tabuleiro[i][2] == pecaX ||

				//Ou na coluna, com j como qualquer coluna e i como a localização na linha

				tabuleiro[0][j] == pecaX && tabuleiro[1][j] == pecaX && 
				tabuleiro[2][j] == pecaX || 

				//Ou nas duas diagonais, com a localização exata

				tabuleiro[0][0] == pecaX && tabuleiro[1][1] == pecaX &&
				tabuleiro[2][2] == pecaX || tabuleiro[0][2] == pecaX && tabuleiro[1][1] == pecaX &&
				tabuleiro[2][0] == pecaX){

				//Atualiza a variável como "verdadeira"

					vitoriaX = true;

			//Caso exista três Y seguidos em coluna ou em linha, ou tenha três Y nas diagonais

				//Na linha, com i como qualquer linha e j como a localização na coluna 	

				}else if(tabuleiro[i][0] == pecaY &&
				tabuleiro[i][1] == pecaY && tabuleiro[i][2] == pecaY || 

				//Ou na coluna, com j como qualquer coluna e i como a localização na linha

				tabuleiro[0][j] == pecaY && tabuleiro[1][j] == pecaY && 
				tabuleiro[2][j] == pecaY ||

				//Ou nas duas diagonais, com a localização exata

				tabuleiro[0][0] == pecaY && tabuleiro[1][1] == pecaY &&
				tabuleiro[2][2] == pecaY || tabuleiro[0][2] == pecaY && tabuleiro[1][1] == pecaY &&
				tabuleiro[2][0] == pecaY){

				//Atualiza a variável como "verdadeira"
							
							vitoriaY = true;

				//Para verificação da quantidade de espaços vazios (' ') no jogo
					
				} else if(tabuleiro[i][j] == espacoVazio){
							
				//Aumenta em 1 a variável
	
					quantidadeVazios ++;
				
						}

		//Condições para avaliação do status do jogo.

			/* 
			   Primeiro caso - Caso o Jogo não seja Iniciado ainda.
			   Espaco vazio em todas as linhas e todas as colunas, ou seja, nos 9 espaços.
			   Status como zero.
	
			*/
	
				if(quantidadeVazios == 9){
					
					status = 0;
				
			/*
			   Segundo caso - Caso o primeiro jogador (X) ganhe.
			   Caractere 'X' nos três espaços de uma linha, nos três espaços de uma coluna ou nas diagonais.
			   Variável 'vitoriaX' como verdadeira.
			   Status como 1.
			*/
			

				}else if(vitoriaX == true){
							
					status = 1;

			/*
			   Terceiro caso - Caso o segundo jogador (Y) ganhe.
			   Caractere 'Y' nos três espaços de uma linha, nos três espaços de uma coluna ou nas diagonais.
			   Variável 'vitoriaY' como verdadeira.
			   Status como 2.
			
			*/

				}else if(vitoriaY == true){
							
					 status = 2;

			/*
			   Quarto caso - Caso ocorra um empate.
			   Todas as linhas e colunas preenchidas com X ou Y, mas nenhum ganhador.
			   Sem espaços vazios no jogo.
			   Status como 3.
			
			*/

				}else if(quantidadeVazios == 0){
							
					status = 3;

			/*
			   Quinto caso - Jogo iniciado e em andamento.
			   Nem todas as linhas e colunas preenchidas com X ou Y.
			   Status como 4.
			
			*/
				}else 
					status = 4;
			}
		}
		return status;
	}
	

	/*
		Apenas para seus testes. ISSO SERa IGNORADO NA CORREcaO
	*/
	public static void main(String[] args) {
		// escreva seu código (para testes) aqui
		
    	char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	char[][] tab1 = {{'X','X','X'},{'O','O',' '},{' ',' ',' '}};
	char[][] tab2 = {{'O','X','X'},{'X','O','O'},{' ',' ','O'}};
	char[][] tab3 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
	char[][] tab4 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};

   	char[][] tab5 = {{' ',' ',' '},{'O','O',' '},{'X','X','X'}};
    	char[][] tab6 = {{' ',' ','O'},{'X','O','O'},{'O','X','X'}};
    	char[][] tab7 = {{'X','X','O'},{'O','O','X'},{'X','X','O'}};
    	char[][] tab8 = {{' ','X',' '},{' ','O',' '},{' ','X',' '}};
    	char[][] tab9 = {{' ',' ',' '},{'X','X','X'},{'O','O',' '}};
    	char[][] tab10 = {{'X','O','X'},{'O','O','X'},{'X','O',' '}};
    	char[][] tab11 = {{' ','X','O'},{' ','X',' '},{' ','X','O'}};

    	System.out.println("Status calculado: " + verificaStatus(tab0));
   	System.out.println("Status esperado para o tabuleiro0: 0\n");

    	System.out.println("Status calculado: " + verificaStatus(tab1));
    	System.out.println("Status esperado para o tabuleiro1: 1\n");

    	System.out.println("Status calculado: " + verificaStatus(tab2));
    	System.out.println("Status esperado para o tabuleiro2: 2\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab3));
    	System.out.println("Status esperado para o tabuleiro1: 3\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab4));
    	System.out.println("Status esperado para o tabuleiro4: 4\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab5));
    	System.out.println("Status esperado para o tabuleiro5: 1\n");
     
    	System.out.println("Status calculado: " + verificaStatus(tab6));
    	System.out.println("Status esperado para o tabuleiro6: 2\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab7));
    	System.out.println("Status esperado para o tabuleiro7: 3\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab8));
    	System.out.println("Status esperado para o tabuleiro8: 4\n");

    	System.out.println("Status calculado: " + verificaStatus(tab9));
    	System.out.println("Status esperado para o tabuleiro9: 1\n");
      
    	System.out.println("Status calculado: " + verificaStatus(tab10));
    	System.out.println("Status esperado para o tabuleiro10: 2\n");
      
    	System.out.println("Status calculado: " + verificaStatus(tab11));
    	System.out.println("Status esperado para o tabuleiro11: 1\n");
		
	}
}
