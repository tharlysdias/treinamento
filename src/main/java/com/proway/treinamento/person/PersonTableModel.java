package com.proway.treinamento.person;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tharlys
 */
public class PersonTableModel extends AbstractTableModel {

    private List<String[]> linhas;
    private String[] colunas = new String[]{"Nome", "Sobrenome"};

    public PersonTableModel() {
        linhas = new ArrayList<String[]>();
    }

    public PersonTableModel(List<String[]> lista) {
        linhas = new ArrayList<String[]>(lista); // Lista dos dados que a tabela vai ter
    }

    // SobEscrita, pois estou sobrescrevendo um metodo que está na AbstractTableModel
    @Override
    // Metodo que diz quantas colunas eu tenho
    public int getColumnCount() {
        return colunas.length; // retorna o número de colunas tem na tabela
    }

    @Override
    // Metodo que diz quantas linhas (pessoas) eu vou ter
    public int getRowCount() {
        return linhas.size(); // retorna o número de pessoas que tenho
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    // Metodo que vai dizer qual o valor deve ser exibido em cada linha e coluna
    public Object getValueAt(int rowIndex, int columnIndex) {
        // t - temporario
        String t[] = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return t[0];
            case 1:
                return t[1];
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    // Modifica na linha e coluna especificada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String t[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                t[0] = aValue.toString();
                break;
            case 1:
                t[1] = aValue.toString();
                break;
            default:
                // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Modifica na linha especificada
    public void setValueAt(String aValue[], int rowIndex) {
        String t[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        t[0] = aValue[0];
        t[1] = aValue[1];

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public String[] getPerson(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addPerson(String p[]) {
        // Adiciona o registro.
        linhas.add(p);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    // Remove a linha especificada.
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    // Adiciona uma lista de pessoas ao final dos registros.
    public void addLista(List<String[]> p) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(p);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    // Remove todos os registros.
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    // Verifica se este table model esta vazio.
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
