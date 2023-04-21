# TRABALHO-AVI

## Requisitos:

>maven 3.9.1(https://maven.apache.org/) <br/>
>TomCat 10.1.7(https://tomcat.apache.org/index.html)<br/>
>javaSE-17(https://www.oracle.com/br/java/technologies/downloads/)<br/>

>paginas jsp criadas com o auxilo de bootstrap 5

## TagLib Usada:
```ruby
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
```



## Dependencia no pom.xml:

```ruby
	<dependencies>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
			<version>2.0.0</version>
		</dependency>
	</dependencies>
  ```
 
 O projeto deve ser rodado a partir da jsp index.jsp, ela é um menu de acesso as funcionalidades
 >![image](https://user-images.githubusercontent.com/101946589/233514435-a7a6db2c-f3fc-4e69-850e-a7e3d6985ee9.png)

## Cadastro Coordeandor

Ao acessar essa funcionalidade do menu o usuario é redirecionado a primeira parte do cadastro, uma jsp que recebe a quantidade de horarios que o coordenador irá ter, esse valor é redirecionada a uma servlet que faz o tratamento de erro e, caso não seja captado nenhum erro, redirecionar a segunda parte do cadastro
>![image](https://user-images.githubusercontent.com/101946589/233514746-e9d4afdb-edc0-4a53-a7fe-98026c0330f5.png)
>![image](https://user-images.githubusercontent.com/101946589/233515274-d3349ec7-8403-4938-9fa7-954dc785a8f7.png)

A segunda jsp recebe os valores de quantidade de horários e, em um foreach, repete os inputs de recebimento de disponibilidade de horários dos coordenaodres 

```ruby
	<c:forEach begin="1"end="${not empty param.qtdHorario ? param.qtdHorario : session.qtdHorario}"	varStatus="loop">

					

							<h3 class="mb-4">Disponibilidade ${loop.index}</h3>

							<div class="row">
								<div class="form-group col-md-4">
									<label class="control-label h5">Dia </label>

									<div>
										<input name="dia${loop.index}"
											placeholder="Data disponibilidade" class="form-control"
											type="text">

									</div>

								</div>


								<div class="form-group mb-1 col-md-4">
									<label class="control-label h5">Horario inicial</label>
									<div>
										<input name="horarioInicial${loop.index}"
											placeholder="horario inicial" class="form-control"
											type="text">
									</div>
								</div>

								<div class="form-group mb-1 col-md-4">


									<label class="control-label h5">Horario final</label>
									<div>
										<input name="horaFinal${loop.index}"
											placeholder="horario final" class="form-control" type="text">
									</div>
								</div>
								<hr>


							</div>
						</c:forEach>
```


A jsp manda as infromações do coordenador pra servlet que irá fazer o tratamento de erro e tambem salvar o coordenador em uma lista de coordenadores

```ruby
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String qtdHorario = req.getParameter("qtdHorario");
			Integer repQtdHorario = Integer.parseInt(qtdHorario);
			req.getSession().setAttribute("qtdHorario", qtdHorario);
			Coordenador.validarQtdHorario(repQtdHorario);

			CadastrarHorariosController.qtdRep = repQtdHorario;

			List<PeriodoDisponibilidade> pd = new ArrayList<>();
			for (int i = 1; i <= repQtdHorario; i++) {

				String horaInicial = req.getParameter("horarioInicial" + i);
				String horaFinal = req.getParameter("horaFinal" + i);
				String dia = req.getParameter("dia" + i);
				Coordenador.validarQtdHorarios(dia, horaInicial, horaFinal);
				PeriodoDisponibilidade periodo = new PeriodoDisponibilidade(dia, horaInicial, horaFinal);
				pd.add(periodo);

			}

			String cursos = req.getParameter("curso");

			String nome = req.getParameter("nome");

			Coordenador coordenador = new Coordenador(nome, cursos, pd);

			CoordenadoresDao.adicionar(coordenador);

			req.getSession().setAttribute("coordenadores", CoordenadoresDao.getList());
			resp.sendRedirect("./index.jsp");

		} catch (ValidarException e) {

			req.setAttribute("erroCadastro", "Nenhum campo pode estar vazio, coordenador não cadastrado");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		} catch (NumberFormatException e) {

			req.setAttribute("erroQtd", "Formato inserido invalido");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cadastroCoordenador.jsp");
			requestDispatcher.forward(req, resp);

		}

	}

```

## Exibir Coordenadores: 
Ao acessar esse funcionalidade, o usuario chamsa uma servlet que manda as informações da lista de coordenadores para auma jsp que irá fazer a aexibição da lisrta de coordenadores em forma de uma tabela 
```ruby
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setAttribute("coordenadores", CoordenadoresDao.getList());

		req.getRequestDispatcher("exibirCoordenadores.jsp").forward(req, resp);

	}
```

<br/>

```ruby
<div class="container">
		<div class="d-flex justify-content-center">



			<div class="table-responsive col col-md-12 mx-auto">


				<table class="table table-hover table-bordered w-75 mx-auto"
					style="font-size: 18px;">

					<thead class="table-dark">

						<tr>
							<th class="text-center" scope="col">Nome</th>
							<th class="text-center" scope="col">Cursos</th>
							<th class="text-center" scope="col">Disponibilidade</th>
						</tr>

					</thead>

					<tbody>

						<c:forEach var="coordenadores" items="${coordenadores}">
							<tr>
								<td class="text-center"><c:out
										value="${coordenadores.nome}" /></td>
								<td class="text-center"><c:out
										value="${coordenadores.cursos}" /></td>
								<td class="text-center"><c:out
										value="${coordenadores.disponibilidade}" /></td>

							</tr>
						</c:forEach>


					</tbody>




				</table>



				<div class="col col-md-12  w-75 mx-auto">


					<div class="form-group">
						<label class="col-md-2 control-label" for="prosseguir"></label>
						<div>
							<a href="./index.jsp">

								<button type="submit" name="prosseguir" class="btn btn-success"
									type="Submit">Voltar Para Menu Inicial</button>


							</a>
						
						</div>
					</div>


				</div>


			</div>
		</div>



	</div>
```








 
