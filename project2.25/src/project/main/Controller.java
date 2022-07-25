package project.main;

import project.findId.FindIdController;
import project.findPw.FindPwController;
import project.login.LoginController;
import project.login.LoginDTO;
import project.manager.ManagerController;
import project.manager.ManagerDTO;
import project.manager.dogItemset.DogitemController;
import project.manager.memberList.MemberListController;
import project.manager.memberList.addBoard.AddBoardService;
import project.manager.memberList.addBoard.AddController;
import project.manager.memberList.updatedeleteBoard.UpdateDeleteController;
import project.manager.memberList.updatedeleteBoard.updateBoard.UpdateController;
import project.manager.noticeBoard.NoticeBoardController;
import project.manager.noticeBoard.writing.NoticeWritingController;
import project.manager.reserveList.ReserveListController;
import project.member.MemberController;
import project.member.dogItem.DogShopController;
import project.member.dogItem.bucket.bucketListController;
import project.member.editReg.EditRegController;
import project.member.messageBoard.MessageController;
import project.member.messageBoard.edit.EditController;
import project.member.messageBoard.pwCheck.PwCheckController;
import project.member.messageBoard.select.SelectController;
import project.member.messageBoard.writing.WritingController;
import project.member.messageBoard.writing.WritingService;
import project.member.messageBoard.writing2.WritingController2;
import project.member.notice.NoticeMemberController;
import project.member.reserve.ReserveController;
import project.member.reserve.ReserveService;
import project.reg.RegController;

public class Controller {
	private LoginController loginController;
	private RegController regController;
	private MainService mainService;
	private WritingService writingService;
	private FindIdController findIdController;
	private FindPwController findPwController;
	private MemberController memberController;
	private ManagerController managerController;
	private MessageController messageController;
	private WritingController writingController;
	private SelectController selectController;
	private DogShopController dogShopController;
	private LoginDTO loginDto;
	private ManagerDTO managerDto;
	private ReserveService reserveService;
	private ReserveController reserveController;
	private DogitemController dogitemController;
	private PwCheckController pwCheckController;
	private EditController editController;
	private UpdateDeleteController updatedeleteController;
	private UpdateController updateController;
	private ReserveListController reserveListController;
	private MemberListController memberListController;
	private AddController addController;
	private AddBoardService addBoardService;
	private WritingController2 writingController2;
	private bucketListController bucketListController;
	private EditRegController editRegController;
	private NoticeBoardController noticeBoardController;
	private NoticeWritingController noticeWritingController;
	private NoticeMemberController noticeMemberController;
	
	
	
	
	public Controller() {
		mainService = new MainService();
		mainService.setController(this);
		writingService = new WritingService();
		writingService.setController(this);
		
	
	}
	
	


	public NoticeMemberController getNoticeMemberController() {
		return noticeMemberController;
	}




	public void setNoticeMemberController(NoticeMemberController noticeMemberController) {
		this.noticeMemberController = noticeMemberController;
		this.noticeMemberController.setController(this);
	}





	public NoticeWritingController getNoticeWritingController() {
		return noticeWritingController;
	}






	public void setNoticeWritingController(NoticeWritingController noticeWritingController) {
		this.noticeWritingController = noticeWritingController;
		this.noticeWritingController.setController(this);
	}






	public NoticeBoardController getNoticeBoardController() {
		return noticeBoardController;
	}





	public void setNoticeBoardController(NoticeBoardController noticeBoardController) {
		this.noticeBoardController = noticeBoardController;
		this.noticeBoardController.setController(this);
	}





	public EditRegController getEditRegController() {
		return editRegController;
	}






	public void setEditRegController(EditRegController editRegController) {
		this.editRegController = editRegController;
		this.editRegController.setController(this);
	}










	public ManagerDTO getManagerDto() {
		return managerDto;
	}




	public void setManagerDto(ManagerDTO managerDto) {
		this.managerDto = managerDto;
	}




	public WritingController2 getWritingController2() {
		return writingController2;
	}




	public void setWritingController2(WritingController2 writingController2) {
		this.writingController2 = writingController2;
		this.writingController2.setController(this);
	}







	public AddBoardService getAddBoardService() {
		return addBoardService;
	}






	public void setAddBoardService(AddBoardService addBoardService) {
		this.addBoardService = addBoardService;
		this.addBoardService.setController(this);
	}






	public AddController getAddController() {
		return addController;
	}






	public void setAddController(AddController addController) {
		this.addController = addController;
		this.addController.setController(this);
	}






	public MemberListController getMemberListController() {
		return memberListController;
	}





	public void setMemberListController(MemberListController memberListController) {
		this.memberListController = memberListController;
		this.memberListController.setController(this);
	}





	public ReserveListController getReserveListController() {
		return reserveListController;
	}




	public void setReserveListController(ReserveListController reserveListController) {
		this.reserveListController = reserveListController;
		this.reserveListController.setController(this);
//		AddBoardService addBoardService = new AddBoardService();
//		this.addBoardService.setController(this);
	}




	public UpdateController getUpdateController() {
		return updateController;
	}


	public void setUpdateController(UpdateController updateController) {
		this.updateController = updateController;
		this.updateController.setController(this);
	}


	


	//업데이트딜리트
	public UpdateDeleteController getUpdatedeleteController() {
		return updatedeleteController;
	}



	public void setUpdatedeleteController(UpdateDeleteController updatedeleteController) {
		this.updatedeleteController = updatedeleteController;
		this.updatedeleteController.setController(this);
	}



	public EditController getEditController() {
		return editController;
	}
	
	public void setEditController(EditController editController) {
		this.editController = editController;
		this.editController.setController(this);
	}
	
	public PwCheckController getPwCheckController() {
		return pwCheckController;
	}
	
	public void setPwCheckController(PwCheckController pwCheckController) {
		this.pwCheckController = pwCheckController;
		this.pwCheckController.setController(this);
	}

	public DogitemController getDogitemController() {
		return dogitemController;
	}


	public void setDogitemController(DogitemController dogitemController) {
		this.dogitemController = dogitemController;
		this.dogitemController.setController(this);

	}
	
	//각각의 login, register controller에 연결
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
		this.loginController.setController(this);
	}
	
	public LoginController getLoginController() {
		return loginController;
		
	}
	
	public void setRegController(RegController regController) {
		this.regController = regController;
	}
	
	public RegController getRegController() {
		return regController;
	}
	
	public void setFindIdController(FindIdController findIdController) {
		this.findIdController = findIdController;
	}
	
	public FindIdController getFindIdController() {
		return findIdController;
	}
	
	public void setFindPwController(FindPwController findPwController) {
		this.findPwController = findPwController;
	}
	
	public FindPwController getFindPwController() {
		return findPwController;
	}
	
	
	
	public void setMemberController(MemberController memberController) {
		this.memberController = memberController;
		this.memberController.setController(this);
	}
	
	public MemberController getMemberController() {
		return memberController;
	}
	
	
	public void setMessageController(MessageController messageController) {
		this.messageController = messageController;
		this.messageController.setController(this);
	}
	
	public MessageController getMessageController() {
		return messageController;
	}
	
	public LoginDTO getLoginDto() {
		return loginDto;
	}
	public void setLoginDto(LoginDTO loginDto) {
		this.loginDto = loginDto;
	}
	
	
	
	
	
	public SelectController getSelectController() {
		return selectController;
	}

	public void setSelectController(SelectController selectController) {
		this.selectController = selectController;
		this.selectController.setController(this);
	}

	public WritingController getWritingController() {
		return writingController;
	}

	public void setWritingController(WritingController writingController) {
		this.writingController = writingController;
		this.writingController.setController(this);
	
	}
	public ManagerController getManagerController() {
		return managerController;
	}

	public void setManagerController(ManagerController managerController) {
		this.managerController = managerController;
		this.managerController.setController(this);
	}
	
	
	public bucketListController getBucketListController() {
		return bucketListController;
	}


	public void setBucketListController(bucketListController bucketListController) {
		this.bucketListController = bucketListController;
		this.bucketListController.setController(this);
//		DogShopDAO dogShopDao = new DogShopDAO();
//		dogShopDao.setController(this);
	}
	
	public DogShopController getDogShopController() {
		
		return dogShopController;
		
	}

	public void setDogShopController(DogShopController dogShopController) {
		this.dogShopController = dogShopController;
		this.dogShopController.setController(this);
	}

	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
		
	}

	
	public ReserveController getReserveController() {
		return reserveController;
	}

	public void setReserveController(ReserveController reserveController) {
		this.reserveController = reserveController;
		this.reserveController.setController(this);
	}
	
	
	//오픈실행 아이디찾기,비번, 회원가입, 애견샵, 로그인 수행
	public void open(String division) {
	
		if("Register".equals(division)) {
			mainService.regOpen();
		}else if("FindId".equals(division)){
			mainService.findIdOpen();
		}else if ("FindPw".equals(division)) {
			mainService.findPwOpen();
		}else if("Manager".equals(division)) {
			mainService.managerPageOpen();
		}else if ("Member".equals(division)) {
			mainService.memberPageOpen();
		}else if ("LoginPage".equals(division)) {
			mainService.loginPageOpen();
		}
	}


	

	

}
