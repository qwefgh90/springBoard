package board.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import board.board.model.BoardVo;
import board.board.service.BoardService;
import board.board.service.BoardServiceInf;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	@Resource(name="boardService")
	BoardServiceInf boardService;

	// left 를 호출 전, preHandler
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		System.out.println("=--===========================preHandle board INterceptor");
		
		List<BoardVo> boardList = boardService.getAllBoards();
		request.setAttribute("boardList", boardList);
		
		return true;
	}
	
}
