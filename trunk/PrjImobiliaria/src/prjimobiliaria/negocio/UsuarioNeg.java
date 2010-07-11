/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prjimobiliaria.negocio;

import java.util.ArrayList;
import prjimobiliaria.dao.UsuarioDao;

/**
 *
 * @author Elissandro
 */
public class UsuarioNeg {

   private UsuarioDao usuarioDao = new UsuarioDao();

   public boolean inserirUsuario(Usuario usuario) throws Exception {

       return usuarioDao.inserirUsuario(usuario);
   }

   public boolean alterarUsuario(Usuario usuario) throws Exception {

       return usuarioDao.alterarUsuario(usuario);
   }

   public boolean excluirUsuario(int idUsuario) throws Exception {

       return usuarioDao.excluirUsuario(idUsuario);
   }

   public ArrayList<Usuario> obterTodosUsuario() throws Exception {

       return usuarioDao.obterTodosUsuario();
   }

   public Usuario obterUsuarioPorId(int idUsuario) throws Exception {

       return usuarioDao.obterUsuarioPorId(idUsuario);
   }

   public Usuario obterUsuarioPorCpf(String cdCpf) throws Exception {

       return usuarioDao.obterUsuarioPorCpf(cdCpf);
   }

   public ArrayList<Usuario> obterUsuarioPorPerfil(char tpPerfil) throws Exception {

       return usuarioDao.obterUsuarioPorPerfil(tpPerfil);
   }

   public boolean ehSenhaValida(String dsSenha) throws Exception {

       if(dsSenha.length() >= 5) {
          return true;
       }
         
       throw new Exception("A senha deve ter no mínimo 5 caracteres!");
   }

}
