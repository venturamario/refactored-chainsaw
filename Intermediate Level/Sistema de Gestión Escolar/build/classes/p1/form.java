package p1;

import javax.swing.JOptionPane;

public class form extends javax.swing.JFrame {
    
    //----------------------------------------------VARIABLES-----------------------------------------------------
    //LISTA DE TODOS LOS CURSOS
    public static ListaCursos listaC = new ListaCursos();
    //LISTA DE TODAS LAS ASIGNATURAS
    public static ListaAsignaturas listaA = new ListaAsignaturas();
    //LISTA DE TODOS LOS ESTUDIANTES
    public static ListaEstudiantes listaE = new ListaEstudiantes();

    //----------------------------------------------MÉTODOS------------------------------------------------------
    //CONSTRUCTOR
    public form(ListaCursos C, ListaAsignaturas A, ListaEstudiantes E) {
        initComponents();
        this.setVisible(true);
        this.setLocation(280, 150);
        this.setSize(800, 480);
        listaC = C;
        listaE = E;
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
        BotonMostrarLista.setFont(new java.awt.Font("Bandung", 1, 24)); // NOI18N
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
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BotonMostrarLista)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(BotonMostrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        getContentPane().add(jPanel3);
        jPanel3.setBounds(-10, -10, 810, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //____________________________EVENTOS ASOCIADOS A CADA BOTÓN   
    //SALIR DEL PROGRAMA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }
    
    //AÑADIR ALUMNO
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //Buscar la asignatura que se desea
        int codigoBuscar = leerNum("¿CÓDIGO DE LA ASIGNATURA A BUSCAR?");
        Asignatura a = null;
        a = listaA.busqueda(codigoBuscar);
        
        //Si no se ha encontrado la asignatura, avisar al usuario
        if (a == null) {
            aviso("NO SE HA ENCONTRADO LA ASIGNATURA");
        } else {
            //Crear un alumno y matricularlo
            String n = leerCadena("NOMBRE DEL ESTUDIANTE A MATRICULAR");
            String dni = leerCadena("DNI DEL ESTUDIANTE A MATRICULAR");
            //Crear alumno e insertarlo en una lista
            Estudiante e = new Estudiante(n, dni);
            listaE.insertar(e);
            a.matricular(e);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //ELIMINAR ASIGNATURA
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    //DAR DE ALTA UN CURSO
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        //ATRIBUTOS DEL CURSO
        String nombre;
        int codigo, numA=0;
        cursoB tipoBach = null;
        tipoFP tipoFp = null;
        ListaAsignaturas listaAsig = new ListaAsignaturas();
        
        //ESPECIFICAR QUE TIPO DE CURSO ES
        int eleccion;
        eleccion = escogerCurso("¿QUÉ TIPO DE CURSO ES?"); //1 Bach, 2 fp 
        if (eleccion == 2) {
            //ES BACHILLER
            nombre = leerCadena("INTRODUCE EL NOMBRE DEL CURSO");
            codigo = leerNum("INTRODUCE EL CÓDIGO DEL CURSO");
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
            Curso curso = new Curso(codigo,nombre,tipoBach);
            listaC.insertar(curso);
            
            
            //------------------CREAR LAS ASIGNATURAS DEL CURSO-----------------
            numA = leerNum("INTRODUCE EL Nº DE ASIGNATURAS DEL CURSO");
            curso.setNumAsignaturas(numA); 
            //CREAR n ASIGNATURAS 
            for (int i = 0; i < numA; i++) {
                //Decidir tipo de asignatura
                int opcion = escogerTipoAsignatura("¿DE QUÉ TIPO ES LA ASIGNATURA "+(i+1)+"?");
                if (opcion == 1) {
                    //Es Obligatoria
                    String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                    int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                    Integer creditos = leerNum("INTRODUCE EL NÚMERO DE CRÉDITOS DE LA ASIGNATURA " + (i + 1));
                    
                    //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                    Asignatura o = new Asignatura(c,n,null,creditos);
                    listaA.insertar(o);
                    listaAsig.insertar(o);
                    curso.setListaAsignaturas(listaAsig);
                    
                } else if (opcion == 2) {
                    //Es Optativa
                    String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                    int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
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
                    Asignatura o = new Asignatura(c,n,tipo,null);
                    listaA.insertar(o);
                    listaAsig.insertar(o);
                    curso.setListaAsignaturas(listaAsig);
                }               
            }
        } else if (eleccion == 1) {
            //ES FP
            nombre = leerCadena("INTRODUCE EL NOMBRE DEL CURSO");
            codigo = leerNum("INTRODUCE EL CÓDIGO DEL CURSO");
            int elegir = escogerFP("¿QUÉ ESPECIALIDAD DE FP ES?");
            if (elegir == 1) {
                //Es electrónica
                tipoFp = tipoFP.ELECTRÓNICA;
            } else if (elegir == 2) {
                //Es informatica
                tipoFp =  tipoFP.INFORMÁTICA;
            } else if (elegir == 3) {
                //Es mecánica
                tipoFp = tipoFP.MECÁNICA;
            }
            //Crear curso específico
            Curso FP = new Curso(codigo,nombre,tipoFp);  
            listaC.insertar(FP);
            
            //Leer cantidad de asignaturas del curso
            numA = leerNum("INTRODUCE EL Nº DE ASIGNATURAS DEL CURSO");
            
            //CREAR n ASIGNATURAS 
            for (int i = 0; i < numA; i++) {
                //Decidir tipo de asignatura
                int opcion = escogerTipoAsignatura("¿DE QUÉ TIPO ES LA ASIGNATURA "+(i+1)+"?");
                if (opcion == 1) {
                    //Es Obligatoria
                    String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                    int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
                    Integer creditos = leerNum("INTRODUCE EL NÚMERO DE CRÉDITOS DE LA ASIGNATURA " + (i + 1));
                    
                    //CREAR ASIGNATURA Y AÑADIRLA A LA LISTA GENERAL Y A LA LISTA EN CONCRETO DEL CURSO
                    Asignatura o = new Asignatura(c,n,null,creditos);
                    listaA.insertar(o);
                    listaAsig.insertar(o);
                    FP.setListaAsignaturas(listaAsig);
                    
                } else if (opcion == 2) {
                    //Es Optativa
                    String n = leerCadena("INTRODUCE EL NOMBRE DE LA ASIGNATURA " + (i + 1));
                    int c = leerNum("INTRODUCE EL CÓDIGO DE LA ASIGNATURA " + (i + 1));
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
                    Asignatura o = new Asignatura(c,n,tipo,null);
                    listaA.insertar(o);
                    listaAsig.insertar(o);
                    FP.setListaAsignaturas(listaAsig);
                }               
            }
        }
        System.out.println("HOLA");
        //listaA.ordenacionBurbuja(listaA.getSize());
    }//GEN-LAST:event_jButton6ActionPerformed

    //DAR DE BAJA UN CURSO
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //DAR DE BAJA UN PUTO CURSO DE LOS COJONES
        int eleccion = leerNum("INTRODUCE EL CÓDIGO DEL CURSO A ELIMINAR");
        Curso c = null;
        c = listaC.busqueda(eleccion);
        
        //SI C ES NULL NO SE HA ENCONTRADO UN CURSO CON ESE CODIGO DIOOOOOS
        if (c==null) {
            aviso("NO SE HA ENCONTRADO UN CURSO CON ESE CÓDIGO");
        } else {
            
            //ELIMINAR ALUMNOS MATRICULADOS A UN CURSO (Asignatura tiene lista estudiantes asociado)
            ListaAsignaturas listaEliminar = c.getListaAsignaturas();
            listaEliminar.eliminarEstudiantes();
            
            //ELIMINAR ASIGNATURAS DEL CURSO (Cada curso tiene una lista de asignaturas asociado)
            listaEliminar.eliminarAsignaturas();
            
            //ELIMINAR EL CURSO
            listaC.eliminar(eleccion);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    //MOSTRAR LISTAS
    private void BotonMostrarLista(java.awt.event.ActionEvent evt) {
        
        //Escoger la lista que deseas ver
        int eleccion = escogerLista("¿QUÉ LISTA DESEAS VER?");
        
        switch (eleccion) {
            case 1:
                //Mostrar lista de cursos
                mostrarLista c = new mostrarLista(listaC, listaA, listaE, 1);
                c.setVisible(true);
                this.dispose();
                break;
                
            case 2:
                //ESCOGER EL CURSO DEL CUAL SE VAN A MOSTRAR LAS ASIGNATURAS
                int usuario = leerNum("CÓDIGO DEL CURSO CUYAS ASIGNATURAS QUIERES VER");
                Curso cursoBuscar = listaC.busqueda(usuario);
                
                //MOSTRAR LA LISTA DE ASIGNATURAS ASOCIADA AL CURSO BUSCADO
                if (cursoBuscar == null) {
                    aviso("NO SE HA ENCONTRADO UN CURSO CON ESTE CÓDIGO");
                } else {
                    ListaAsignaturas listaAsig = cursoBuscar.getListaAsignaturas();
                    ListaEstudiantes litaEst = new ListaEstudiantes();
                    
                    System.out.println(listaAsig.getSize());
                    mostrarLista a = new mostrarLista(listaC, listaAsig, listaE, 2);
                    a.setVisible(true);
                    this.dispose();
                }
                break;
                
            case 3:
                //Mostrar lista de estudiantes
                mostrarLista e = new mostrarLista(listaC, listaA, listaE, 3);
                e.setVisible(true);
                this.dispose();
                break;               
        }         
    }
    
    //____________________________MÉTODOS DE LEER DATOS CON GRÁFICOS  
    //LEER NUMERO
    private int leerNum(String s) {
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
                new Object[]{"CURSOS", "ASIGNATURAS" , "ESTUDIANTES"}, "opcion 1");
        
        //DEVOLVER CUÁL DE LAS DOS OPCIONES SE HA ESCOGIDO
        return (seleccion+1);
    }
    
    
    //____________________________MÉTODOS GETTER DE LAS LISTAS GENERALES
    public static ListaCursos getListaCursos() {
        return listaC;
    }
    public static ListaAsignaturas getListaAsignaturas() {
        return listaA;
    }
    public static ListaEstudiantes getListaEstudiantes() {
        return listaE;
    }
    
    //____________________________MÉTODO MAIN
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form(listaC,listaA,listaE).setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
