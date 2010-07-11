/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.negocio;

import java.util.ArrayList;
import prjimobiliaria.dao.PessoaDao;

/**
 *
 * @author Elissandro
 */
public class PessoaNeg {

    private PessoaDao pessoaDao = new PessoaDao();

   public boolean inserirPessoa(Pessoa pessoa) throws Exception {

       return pessoaDao.inserirPessoa(pessoa);
   }

   public boolean alterarPessoa(Pessoa pessoa) throws Exception {

       return pessoaDao.alterarPessoa(pessoa);
   }

   public boolean excluirPessoa(int idPessoa) throws Exception {

       return pessoaDao.excluirPessoa(idPessoa);
   }

   public ArrayList<Pessoa> obterTodosPessoa() throws Exception {

       return pessoaDao.obterTodosPessoa();
   }

   public Pessoa obterPessoaPorId(int idPessoa) throws Exception {

       return pessoaDao.obterPessoaPorId(idPessoa);
   }

   public Pessoa obterPessoaPorCpf(String cdCpf) throws Exception {

       return pessoaDao.obterPessoaPorCpf(cdCpf);
   }

}
