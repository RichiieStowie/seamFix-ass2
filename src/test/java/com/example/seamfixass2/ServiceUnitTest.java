package com.example.seamfixass2;

import com.example.seamfixass2.exception.InvalidArgumentException;
import com.example.seamfixass2.exception.ResourceEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTest {
    @Mock
    public ResponseRepository responseRepository;
    @InjectMocks
    public Service service;

    @Test
    public void testSuccessfulPath(){
        String bvn = "123456789876";
       BDDMockito.given(responseRepository.save(bvn))
                .willReturn(bvn);
       ResponseDto responseDto = service.getDetails(bvn);
        Assertions.assertEquals(bvn,responseDto.id);
    }

    @Test
    public void shouldThrowResourceEmptyExceptionWithEmptyBvn(){
        String bvn = "";
        ResourceEmptyException thrown = Assertions.assertThrows(ResourceEmptyException.class, () ->{
           service.getDetails(bvn);
       });
        Assertions.assertEquals("One or More of your request parameter failed again. Please try again", thrown.getMessage());
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionWithNonDigitPresent(){
        String bvn = "ab564272";
        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () ->{
            service.getDetails(bvn);
        });
        Assertions.assertEquals("The searched BVN is invalid",
                thrown.getMessage());
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionWithBvnLengthLessThanExpected(){
        String bvn = "12564272";
        InvalidArgumentException thrown = Assertions.assertThrows(InvalidArgumentException.class, () ->{
            service.getDetails(bvn);
        });
        Assertions.assertEquals("The searched BVN is invalid",
                thrown.getMessage());
    }
    @Test
    public void shouldCallTheDbSaveMethodAtLeastOnce(){
        String bvn = "123456789876";
        ResponseDto responseDto = service.getDetails(bvn);
        Mockito.verify(responseRepository,Mockito.times(1)).save(bvn);

    }
}
