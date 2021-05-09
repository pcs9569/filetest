package fishbun.fishbunspring.service;

import fishbun.fishbunspring.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);

    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new JdbcTemplateUserRepository(dataSource);
    }

    @Bean
    public StoreService storeService() { return new StoreService(storeRepository()); }

    @Bean
    public StoreRepository storeRepository() { return new JdbcTemplateStoreRepository(dataSource); }

    @Bean
    public ReviewService reviewService() { return new ReviewService(reviewRepository()); }

    @Bean
    public ReviewRepository reviewRepository() { return new JdbcTemplateReviewRepository(dataSource); }

    @Bean
    public KindService kindService() { return new KindService(kindRepository()); }

    @Bean
    public KindRepository kindRepository() { return new JdbcTemplateKindRepository(dataSource); }

    @Bean
    public NotifyService notifyService() { return new NotifyService(notifyRepository()); }

    @Bean
    public NotifyRepository notifyRepository() { return new JdbcTemplateNotifyRepository(dataSource);}

    @Bean
    public LikesService likesService() { return new LikesService(likesRepository());}

    @Bean
    public LikesRepository likesRepository() { return new JdbcTemplateLikesRepository(dataSource);}

    @Bean
    public StarService starService() { return new StarService(starRepository());}

    @Bean
    public StarRepository starRepository() { return new JdbcTemplateStarRepository(dataSource);}

//    @Bean
//    public FileUpDownService fileService() { return new FileUpDownService(fileRepository());}

    @Bean
    public FileRepository fileRepository() { return new JdbcTemplateFileRepository(dataSource);}
//    @Bean
//    public FileUploadDownloadService service(){
//        return new FileUploadDownloadService();
//    }
}
