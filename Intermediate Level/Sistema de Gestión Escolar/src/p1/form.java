/*
PRÁCTICA EVALUABLE 1

Asignatura:    Algoritmia y Estructuras de Datos
Autores:       Mario Ventura, Luis Miguel Vargas, Felip Toni Font
Fecha:         05-12-2021
*/

package p1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class form extends javax.swing.JFrame {
    
    //----------------------------------------------VARIABLES-----------------------------------------------------
    //LISTA DE TODOS LOS CURSOS
    public static ListaCursos listaC = new ListaCursos();
    //LISTA DE TODOS LOS ESTUDIANTES
    public static ListaEstudiantes listaE = new ListaEstudiantes();

    //----------------------------------------------MÉTODOS------------------------------------------------------
    //CONSTRUCTOR
    public form() {
        try {
            initComponents();
            this.setVisible(true);
            this.setLocation(280, 150);
            this.setSize(800, 480);
        } catch (Exception e) {
            System.out.println("");
        }
        
    }
    
    //GRÁFICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BotonMostrarLista = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bandung", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIÓN ESCOLAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12))
        );

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Dubai", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿QUÉ DESEAS HACER?");

        jLabel3.setBackground(new java.awt.Color(0, 153, 204));
        jLabel3.setFont(new java.awt.Font("Bandung", 0, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CURSOS");

        jLabel4.setBackground(new java.awt.Color(0, 153, 204));
        jLabel4.setFont(new java.awt.Font("Bandung", 0, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ASIGNATURAS");

        jLabel5.setFont(new java.awt.Font("Bandung", 0, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ALUMNOS");

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Bandung", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 102));
        jButton2.setText("MATRICULAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Bandung", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setText("DAR DE BAJA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 153, 255));
        jButton6.setFont(new java.awt.Font("Bandung", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 51, 102));
        jButton6.setText("DAR DE ALTA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 153, 255));
        jButton7.setFont(new java.awt.Font("Bandung", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 102));
        jButton7.setText("DAR DE BAJA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bandung", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("MARIO VENTURA  |  LUIS MIGUEL VARGAS  |  FELIP TONI FONT");

        BotonMostrarLista.setBackground(new java.awt.Color(0, 51, 102));
        BotonMostrarLista.setFont(new java.awt.Font("Bandung", 1, 22)); // NOI18N
        BotonMostrarLista.setForeground(new java.awt.Color(255, 255, 255));
        BotonMostrarLista.setText("MOSTRAR LISTA");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Bandung", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALIR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonMostrarLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(151, 151, 151)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BotonMostrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BotonMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarLista(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel7.setIcon(new ImageIcon("C:\\Users\\mvent\\OneDrive\\Escritorio\\Mario\\8. UIB\\2º CARRERA\\1 SEMESTRE\\1. ALGORÍTMICA Y ESTRUCTURA DE DATOS 1\\PRACTICAS\\P1 GESTIÓN ESCOLAR\\P1\\LISTA.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\mvent\\OneDrive\\Escritorio\\Mario\\8. UIB\\2º CARRERA\\1 SEMESTRE\\1. ALGORÍTMICA Y ESTRUCTURA DE DATOS 1\\PRACTICAS\\P1 GESTIÓN ESCOLAR\\P1\\ALUMNO.png"));

        getContentPane().add(jPanel3);
        jPanel3.setBounds(-10, -10, 810, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //____________________________EVENTOS ASOCIADOS A CADA BOTÓN   
    //SALIR DEL PROGRAMA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }
    
    //MATRICULAR ALUMNO
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //COMPROBAR A PARTIR DE UN CÓDIGO SI UNA ASIGNATURA YA EXISTE
        Integer codigoBuscar = leerNum("¿CÓDIGO DE LA ASIGNATURA A BUSCAR?");
        Boolean encontrada = codigoUsado(codigoBuscar);
        
        if (encontrada == false) {
            //AVISAR AL USUARIO DE QUE NO SE HA ENCONTRADO LA ASIGNATURA
            aviso("NO SE HA ENCONTRADO LA ASIGNATURA");
        } else {
            //MATRICULAR ALUMNO EN LA ASIGATURA
            String n = leerCadena("NOMBRE DEL ESTUDIANTE A MATRICULAR");
            String dni = leerCadena("DNI DEL ESTUDIANTE A MATRICULAR");
            Estudiante e = new Estudiante(n,dni);
            
            //VARIABLES AUXILIARES
            Asignatura aux;
            Curso auxC;
            Estudiante auxE;
            
            //BUSCAR SI ESTE ALUMNO YA ESTÁ MATRICULADO EN OTRA ASIGNATURA
            for (auxC = listaC.getPrimero(); auxC != null; auxC = auxC.getSig()) {
                for (aux = auxC.getListaAsignaturas().getPrimero(); aux != null; aux = aux.getSig()) {
                    for(auxE = aux.getListaEstudiantes().getPrimero(); auxE!=null; auxE=auxE.getSig()) {
                        if(dni.equals(auxE.getDNI())) {
                            //SI EL ALUMNO ESTA MATRICULADO A OTRA ASIGNATURA, COGEMOS SU LISTA
                            e.setListaAsignaturas(auxE.getListaAsignaturas());
                            break;
                        }
                    }
                }
            }
            
            //ITERAR TODOS LOS CURSOS Y COGER LA LISTA DE ASIGNATURAS DE CADA UNO
            for (auxC = listaC.getPrimero(); auxC != null; auxC = auxC.getSig()) {

                //MIRAR CADA ASIGNATURA DEL CURSO PARA VER SI ES LA QUE SE BUSCA
                for (aux = auxC.getListaAsignaturas().getPrimero(); aux != null; aux = aux.getSig()) {

                    //SI ESTAMOS SOBRE LA ASIGNATURA QUE BUSCAMOS, AÑADIMOS AL ALUMNO
                    if (aux.getCodigo() == codigoBuscar) {
                        //INSERTAR EL ESTUDIANTE EN LA LISTA DE ESTUDIANTES DE LA ASIGNATURA
                        e.setSig(null);
                        aux.getListaEstudiantes().insertar(e);
                        
                        //INSERTAR ASIGNATURA EN LA LISTA DE ASIGNATURAS A LAS QUE ESTA MATRICULADO EL ESTUDIANTE
                        Asignatura a = new Asignatura(aux.getCodigo(), aux.getNombre(), aux.getPerfil(),aux.getCreditos(),aux.getListaEstudiantes());
                        a.setSig(null);
                        e.getListaAsignaturas().insertar(a);
                        e.setNumAsignaturas(e.getNumAsignaturas()+1);
                    }
                }
            }
            
            //AVISAR AL USUARIO QUE LA OPERACIÓN SE HA REALIZADO CORRECTAMENTE
            aviso("EL ALUMNO "+n+" SE HA MATRICULADO CORRECTAMENTE");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //ELIMINAR ASIGNATURA
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //BUSCAR ASIGNATURA
        int codigoBuscar = leerNum("CÓDIGO DE LA ASIGNATURA A BUSCAR");
        boolean encontrado = asignaturaEncontrada(codigoBuscar);
        
        if(encontrado == false) {
            aviso("NO EXISTE UNA ASIGNATURA CON ESE CÓDIGO");
        } else {
            Curso auxC;
            Asignatura auxA;
            Estudiante auxE;
            boolean acabado = false;
            
            //ITERAR CURSOS
            for(auxC=listaC.getPrimero(); auxC!=null; auxC=auxC.getSig()) {
                //ITERAR ASIGNATURAS
                for(auxA=auxC.getListaAsignaturas().getPrimero(); auxA!=null; auxA=auxA.getSig()) {
                    //Comprobar si se ha encontrado la asigmatura
                    if (auxA.getCodigo() == codigoBuscar) { 
                        //SI HAY ALGUN ALUMNO MATRICULADO EN LA ASIGNATURA, ELIMINARLA DE AHÍ
                        for (auxE = auxA.getListaEstudiantes().getPrimero(); (auxE!=null && acabado==false); auxE = auxE.getSig()) {
                            auxE.eliminarAsignatura(codigoBuscar);
                        }
                        //ELIMINAR LA ASIGNATURA DE LA LISTA DE ASIGNATURAS DEL CURSO
                        auxC.getListaAsignaturas().eliminar(auxA.getCodigo());
                        acabado = true;
                    }
                }
            }
            
            aviso("LA ASIGNATURA SE HA ELIMINADO CORRECTAMENTE");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    //DAR DE ALTA UN CURSO
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        //ATRIBUTOS DEL CURSO
        String nombre;
        int codigo, numA=0;
        cursoB tipoBach = null;
        tipoFP tipoFp = null;
        
        //ESPECIFICAR QUE TIPO DE CURSO ES
        int eleccion;
        eleccion = escogerCurso("¿QUÉ TIPO DE CURSO ES?"); 
        if (eleccion == 2) {
            //ES BACHILLER
            nombre = leerCadena("INTRODUCE EL NOMBRE DEL CURSO");
            codigo = leerNum("INTRODUCE EL CÓDIGO DEL CURSO");
            
            //Comprobar si el código ya esta en uso
            if (listaC.codigoUsado(codigo)==false) {
                //ESPECIFICAR EL TIPO DE BACHILLER
                int elegir = escogerBachillerato("¿ES PRIMERO O SEGUNDO?");
                if (elegir == 1) {
                    //Es primero
                    tipoBach = cursoB.PRIMERO;
                } else if (elegir == 2) {
                    //Es segundo
                    tipoBach = cursoB.SEGUNDO;
                }
                //CREAR CURSO DE BACHILLER
                Curso curso = new Curso(codigo, nombre, tipoBach);
                

                //------------------CREAR LAS ASIGNATURAS DEL CURSO-----------------
                numA = leerNum("INTRODUCE EL Nº DE ASIGNATURAS DEL CURSO");
                curso.setNumAsignaturas(numA);
                //CREAR n ASIGNATURAS 
                for (int i = 0; i < numA; i++) {
                    //Decidir tipo de asignatura
                    int opcion = escogerTipoAsignatura("¿DE QUÉ TIPO ES LA ASIGNATURA " + (i + 1) + "?");
                    if (opcion == 1) {
                        //Es Obligatoria
                        String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                        int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                        if (codigoUsado(c) == false) {
                            Integer creditos = leerNum("INTRODUCE EL NÚMERO DE CRÉDITOS DE LA ASIGNATURA " + (i + 1));
                            //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                            Asignatura o = new Asignatura(c, n, null, creditos);
                            o.setSig(null);
                            curso.getListaAsignaturas().insertar(o);
                        } else {
                            aviso("YA EXISTE UNA ASIGNATURA CON ESTE CÓDIGO");
                            i--;
                        }
                        
                    } else if (opcion == 2) {
                        //Es Optativa
                        String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                        int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                        if (codigoUsado(c) == false) {
                            tipoOptativa tipo = null;
                            int opcion2 = escogerTipoOptativa("¿QUÉ TIPO DE OPTATIVA ES?");
                            if (opcion2 == 1) {
                                //Es teórica
                                tipo = tipoOptativa.TEÓRICA;
                            } else if (opcion2 == 2) {
                                //Es práctica
                                tipo = tipoOptativa.PRÁCTICA;
                            }

                            //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                            Asignatura o = new Asignatura(c, n, tipo, null);
                            o.setSig(null);
                            curso.getListaAsignaturas().insertar(o);
                        } else {
                            aviso("YA EXISTE UNA ASIGNATURA CON ESTE CÓDIGO");
                            i--;
                        }
                    }
                }
                curso.setSig(null);
                listaC.insertar(curso);
            } else {
                aviso("YA EXISTE UN CURSO CON ESTE CÓDIGO");
            }
            
            
            
        } else if (eleccion == 1) {
            //ES FP
            nombre = leerCadena("INTRODUCE EL NOMBRE DEL CURSO");
            codigo = leerNum("INTRODUCE EL CÓDIGO DEL CURSO");
            
            //Comprobar si el código ya está en uso
            if (listaC.codigoUsado(codigo)==false) {
                int elegir = escogerFP("¿QUÉ ESPECIALIDAD DE FP ES?");
                if (elegir == 1) {
                    //Es electrónica
                    tipoFp = tipoFP.ELECTRÓNICA;
                } else if (elegir == 2) {
                    //Es informatica
                    tipoFp = tipoFP.INFORMÁTICA;
                } else if (elegir == 3) {
                    //Es mecánica
                    tipoFp = tipoFP.MECÁNICA;
                }
                //Crear curso específico
                Curso FP = new Curso(codigo, nombre, tipoFp);
                listaC.insertar(FP);

                //Leer cantidad de asignaturas del curso
                numA = leerNum("INTRODUCE EL Nº DE ASIGNATURAS DEL CURSO");

                //CREAR n ASIGNATURAS 
                for (int i = 0; i < numA; i++) {
                    //Decidir tipo de asignatura
                    int opcion = escogerTipoAsignatura("¿DE QUÉ TIPO ES LA ASIGNATURA " + (i + 1) + "?");
                    if (opcion == 1) {
                        //Es Obligatoria
                        String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                        int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                        if (codigoUsado(c) == false) {
                            Integer creditos = leerNum("INTRODUCE EL NÚMERO DE CRÉDITOS DE LA ASIGNATURA " + (i + 1));
                            //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                            Asignatura o = new Asignatura(c, n, null, creditos);
                            o.setSig(null);
                            FP.getListaAsignaturas().insertar(o);
                        } else {
                            aviso("YA EXISTE UNA ASIGNATURA CON ESTE CÓDIGO");
                            i--;
                        }
                        

                    } else if (opcion == 2) {
                        //Es Optativa
                        String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                        int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                        if (codigoUsado(c) == false) {
                            tipoOptativa tipo = null;
                            int opcion2 = escogerTipoOptativa("¿QUÉ TIPO DE OPTATIVA ES?");
                            if (opcion2 == 1) {
                                //Es teórica
                                tipo = tipoOptativa.TEÓRICA;
                            } else if (opcion2 == 2) {
                                //Es práctica
                                tipo = tipoOptativa.PRÁCTICA;
                            }
                            //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                            Asignatura o = new Asignatura(c, n, tipo, null);
                            o.setSig(null);
                            FP.getListaAsignaturas().insertar(o);
                        } else {
                            aviso("YA EXISTE UNA ASIGNATURA CON ESTE CÓDIGO");
                            i--;
                        }
                    }
                }
            } else {
                aviso("YA EXISTE UN CURSO CON ESTE CÓDIGO");
            }
            
        }      
        aviso("SE HA DADO DE ALTA EL CURSO CORRECTAMENTE");
    }//GEN-LAST:event_jButton6ActionPerformed

    //DAR DE BAJA UN CURSO
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //DAR DE BAJA UN PUTO CURSO DE LOS COJONES
        int eleccion = leerNum("INTRODUCE EL CÓDIGO DEL CURSO A ELIMINAR");
        Curso c = listaC.busqueda(eleccion);
        
        //SI C ES NULL NO SE HA ENCONTRADO UN CURSO CON ESE CODIGO DIOOOOOS
        if (c==null) {
            aviso("NO SE HA ENCONTRADO UN CURSO CON ESE CÓDIGO");
        } else {
            
            //ITERAR LA LISTA DE CURSOS HASTA ENCONTRAR EL CURSO QUE QUEREMOS
            Curso aux;
            Asignatura asigAux;
            Estudiante auxE;
            boolean acabado = false;
            
            for(aux=listaC.getPrimero(); aux!=null; aux=aux.getSig()) {
                //En cada curso, mirar si es el que buscamos eliminar
                if(aux.getCodigo()==eleccion) {
                    //Es el que queremos eliminar. Eliminar estudiantes matriculados a las asignaturas del curso
                    for(asigAux=aux.getListaAsignaturas().getPrimero(); (asigAux!=null && acabado == false); asigAux=asigAux.getSig()) {
                        //Iterar todos los estudiantes
                        for (auxE = asigAux.getListaEstudiantes().getPrimero(); (auxE!=null && acabado==false); auxE = auxE.getSig()) {
                            auxE.eliminarAsignatura(asigAux.getCodigo());
                        }
                    }
                    listaC.eliminar(aux.getCodigo());
                }
            }
            
            aviso("CURSO ELIMINADO DE FORMA SATISFACTORIA");
            
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    //MOSTRAR LISTAS
    private void BotonMostrarLista(java.awt.event.ActionEvent evt) {
        
        //Escoger la lista que deseas ver
        int eleccion = escogerLista("¿QUÉ LISTA DESEAS VER?");
        
        switch (eleccion) {
            case 1:
                //-------------------LISTA DADA UNA ASIGNATURA (ORDENADO)-------------------
                Integer codigoBuscar = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA QUE BUSCAS");
                Boolean encontrada = codigoUsado(codigoBuscar);
                
                if(encontrada == false) {
                    //AVISAR DE QUE NO EXISTE UNA ASIGNATURA CON ESE CÓDIGO
                    aviso("NO EXISTE UNA ASIGNATURA CON ESE CÓDIGO");
                } else {
                    //ITERAR LA LISTA DE CURSOS HASTA ENCONTRAR EL CURSO AL QUE PERTENECE LA ASIGNATURA
                    Curso cursoAux;
                    Asignatura asigAux;
                    String s = "";
                    Boolean acabado = false;
                    
                    for(cursoAux=listaC.getPrimero(); (cursoAux!=null && acabado == false); cursoAux=cursoAux.getSig()) {
                        //ITERAR LA LISTA DE ASIGNATURAS DE CADA CURSO PARA COMPROBAR SI LA ASIGNATURA ESTÁ CONTENIDA EN ÉL
                        for(asigAux=cursoAux.getListaAsignaturas().getPrimero(); (asigAux!=null && acabado == false); asigAux=asigAux.getSig()) {
                            if (asigAux.getCodigo()==codigoBuscar) {
                                s = s + "Pertenece al curso "+cursoAux.toString()+". Estudiantes: ";
                                ListaEstudiantes lista = asigAux.getListaEstudiantes();
                                lista = lista.ordenar();
                                s = s + lista.toString();
                                acabado = true;
                            }  
                        }
                    }
                    
                    //INVOCAR A LA VENTANA QUE MUESTRA LA LISTA
                    mostrarLista c = new mostrarLista(s);
                    c.setVisible(true);
                    this.dispose();
                }
                
                break;
                
            case 2:
                //-------------------LISTA DADO UN CURSO (ORDENADO)-------------------
                int usuario = leerNum("CÓDIGO DEL CURSO CUYAS ASIGNATURAS QUIERES VER");
                Curso cursoBuscar = listaC.busqueda(usuario);
                
                //MOSTRAR LA LISTA DE ASIGNATURAS ASOCIADA AL CURSO BUSCADO
                if (cursoBuscar == null) {
                    aviso("NO SE HA ENCONTRADO UN CURSO CON ESTE CÓDIGO");
                } else {
                    
                    //VARIABLES AUXILIARES
                    Curso c;
                    ListaAsignaturas lista;
                    String s = "";
                    boolean acabado = false;
                    Curso cursoAux;
                    Asignatura asigAux;
                    
                    /*
                    //ITERACIÓN SOBRE LA LISTA DE CURSOS
                    for (c = listaC.getPrimero(); (c!=null && acabado==false); c = c.getSig()) {
                        //Si es el curso que se quiere, mostrar su lista de asignaturas
                        if (c.getCodigo() == usuario) {
                            //ORDENAR LISTA DE ASIGNATURAS
                            lista = c.getListaAsignaturas();
                            lista = lista.ordenar();
                            s = lista.toString();
                            acabado = true;
                        }
                    }
                    */
                    
                    
                    for(cursoAux=listaC.getPrimero(); (cursoAux!=null && acabado == false); cursoAux=cursoAux.getSig()) {
                        //COMPROBAR SI ES EL CURSO QUE BUSCAMOS
                        if (cursoAux.getCodigo() == usuario) {
                            //RECORRER TODAS SUS ASIGNATURAS Y MOSTRAR SU INFORMACIÓN
                            for(asigAux=cursoAux.getListaAsignaturas().getPrimero(); (asigAux!=null && acabado == false); asigAux=asigAux.getSig()) {
                                s = s + asigAux.toString() + ". Estudiantes: " + asigAux.getListaEstudiantes().ordenar().toString()+"----";
                            }
                            acabado = true;
                        }
                    }
                    
                    
                    //Mostrar ventana con la lista
                    mostrarLista a = new mostrarLista(s);
                    a.setVisible(true);
                    this.dispose();
                }
                break;
                
            case 3:
                //-------------------LISTA DADO UN ESTUDIANTE-------------------
                
                //LEER LA INFORMACIÓN DEL ESTUDIANTE A BUSCAR
                String buscar = leerCadena("DNI DEL ESTUDIANTE A BUSCAR");
                Boolean encontrado = alumnoEncontrado(buscar);
                
                if (encontrado == false) {
                    aviso("NO SE HA ENCONTRADO UN ALUMNO CON ESE DNI");
                } else {
                    //VARIABLES AUXILIARES
                    String s = "";
                    Curso cAux;
                    Asignatura aux;
                    Estudiante auxE;
                    ListaAsignaturas lista;
                    boolean acabado = false;

                    //ITERACIÓN SOBRE LA LISTA DE CURSO
                    for (cAux = listaC.getPrimero(); (cAux!=null && acabado== false); cAux = cAux.getSig()) {
                        //ITERACIÓN SOBRE LA LISTA DE ASIGNATURAS
                        for (aux = cAux.getListaAsignaturas().getPrimero(); (aux!=null && acabado==false); aux = aux.getSig()) {
                            //ITERACIÓN SOBRE LA LISTA DE ESTUDIANTES
                            for (auxE = aux.getListaEstudiantes().getPrimero(); (auxE!=null && acabado==false); auxE = auxE.getSig()) {
                                
                                //Comprobar si es el alumno que se busca
                                if (buscar.equals(auxE.getDNI())) {
                                    
                                    //ORDENAR LISTA DE ASIGNATURAS
                                    lista = auxE.getListaAsignaturas();
                                    lista = lista.ordenar();   
                                    //PONER INFORMACIÓN EN EL STRING
                                    s = s + lista.toString2(listaC);
                                    //INDICAR QUE YA SE HA ACABADO LA OPERACIÓN
                                    acabado = true;
                                }
                            }
                        }
                    }
                    //MOSTRAR LA LISTA PASANDO COMO PARÁMETRO EL STRING CREADO
                    mostrarLista e = new mostrarLista(s);
                    e.setVisible(true);
                    this.dispose();
                }
                break;               
        }         
    }
    
    
    //____________________________MÉTODOS DE LEER DATOS CON GRÁFICOS  
    //LEER NUMERO
    private Integer leerNum(String s) {
        //Valor que introducirá el usuario
        Integer usuario = null;
        
        try {
            //Ventana emeregente que permite leer por teclado
            String linea = JOptionPane.showInputDialog(null,s);
            //Leer lo que el usuario introduce
            usuario = Integer.parseInt(linea);
            
        } catch (Exception e) {
           
        }
        return usuario;
    }
    //LEER UN STRING
    private String leerCadena(String s) {
        //Valor que introducirá el usuario
        String linea = null;
        
        try {
            //Ventana emeregente que permite leer por teclado
            linea = JOptionPane.showInputDialog(null,s);
            
        } catch (Exception e) {
           
        }
        return linea;
    }
    //MÉTODO DE AVISO A USUARIO
    public void aviso(String s) {
        JOptionPane.showMessageDialog(null,s);
    }    
    
    
    //____________________________MÉTODOS DE ELECCIÓN DE OPCIONES  
    //MÉTODO PARA ESCOGER EL TIPO DE CURSO (Devuelve 1 si se escoge bachiller, 2 si se escoge fp)
    public int escogerCurso(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"FP", "BACHILLERATO"}, "opcion 1");
        
        return (seleccion+1);
    }
    //MÉTODO PARA ESCOGER TIPO DE BACHILLER. (1 si es PRIMERO, 2 si es SEGUNDO)
    public int escogerBachillerato(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"PRIMERO", "SEGUNDO"}, "opcion 1");
        
        return (seleccion+1);
    }    
    //MÉTODO PARA ESCOGER TIPO DE BACHILLER. (1 si es SEGUNDO, 2 si es PRIMERO)
    public int escogerFP(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"ELECTRÓNICA", "INFORMÁTICA" , "MECÁNICA"}, "opcion 1");
        
        //DEVOLVER CUÁL DE LAS DOS OPCIONES SE HA ESCOGIDO
        return (seleccion+1);
    }   
    //MÉTODO PARA ESCOGER EL TIPO DE ASIGNATURA (1 Obligatoria, 2 Optativa)
    public int escogerTipoAsignatura(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"OBLIGATORIA", "OPTATIVA"}, "opcion 1");
        
        return (seleccion+1);
    }   
    //MÉTODO PARA ESCOGER EL TIPO DE OPTATIVA
    public int escogerTipoOptativa(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"TEÓRICA", "PRÁCTICA"}, "opcion 1");
        
        return (seleccion+1);
    }   
    //MÉTODO PARA ESCOGER QUE LISTA MOSTRAR. (1 CURSOS, 2 ASIGNATURAS, 3 ESTUDIANTES)
    public int escogerLista(String s) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"DADA UNA ASIGNATURA", "DADO UN CURSO" , "DADO UN ESTUDIANTE"}, "opcion 1");
        
        //DEVOLVER CUÁL DE LAS DOS OPCIONES SE HA ESCOGIDO
        return (seleccion+1);
    }
    
    
    //____________________________COMPRUEBAN SI ALGUNA INFORMACIÓN YA ESTÁ EN USO
    //Busca una asignatura con un codigo y devuelve true si la encuentra
    public boolean codigoUsado(int codigo) {
        //Variables auxiliares
        Boolean encontrado = false;
        Curso cAux;
        Asignatura aux;
        
        //Iteracion de la lista de cursos para obtener las asignaturas de cada curso
        for(cAux = listaC.getPrimero(); cAux!=null; cAux=cAux.getSig()) {
            //Iterar lista de asignaturas de cada curso
            for(aux=cAux.getListaAsignaturas().getPrimero(); aux != null; aux=aux.getSig()) {
                if(aux.getCodigo()==codigo) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }
    //Busca un alumno y si lo encuentra devuelve true
    public boolean alumnoEncontrado(String dni) {
        //Variables auxiliares
        Curso cAux;
        Asignatura aux;
        Estudiante auxE;
        
        //Iteracion de la lista de cursos para obtener las asignaturas de cada curso
        for(cAux = listaC.getPrimero(); cAux!=null; cAux=cAux.getSig()) {
            //Iterar lista de asignaturas de cada curso
            for(aux=cAux.getListaAsignaturas().getPrimero(); aux != null; aux=aux.getSig()) {
                //Iterar la lista de estudiantes de cada asignatura
                for(auxE=aux.getListaEstudiantes().getPrimero(); auxE != null; auxE=auxE.getSig()) {
                    //Comprobar si es el alumno que se busca
                    if (auxE.getDNI().equals(dni)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Busca una asignatura y devuelve true si la encuentra
    public boolean asignaturaEncontrada(Integer codigo) {
        //Variables auxiliares
        Curso cAux;
        Asignatura aux;
        
        //Iteracion de la lista de cursos para obtener las asignaturas de cada curso
        for(cAux = listaC.getPrimero(); cAux!=null; cAux=cAux.getSig()) {
            //Iterar lista de asignaturas de cada curso
            for(aux=cAux.getListaAsignaturas().getPrimero(); aux != null; aux=aux.getSig()) {
                //Mirar si es la asignatura que se busca
                if(aux.getCodigo()==codigo) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    //____________________________MÉTODOS GETTER DE LAS LISTAS GENERALES
    public static ListaCursos getListaCursos() {
        return listaC;
    }
    public static ListaEstudiantes getListaEstudiantes() {
        return listaE;
    }
    
    
    //____________________________MÉTODO MAIN
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonMostrarLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}