package parking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VipParkingStrategyTest {

  @Mock
  CarDao carDao;

  @InjectMocks
  VipParkingStrategy vipParkingStrategy;

  @Test
  public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

    /* Exercise 4, Write a test case on VipParkingStrategy.park()
     * With using Mockito spy, verify and doReturn */
      VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());
      ParkingLot parkingLot = spy(new ParkingLot("KFC",5));
      List<ParkingLot> parkingLotList = new ArrayList<>();
      parkingLotList.add(parkingLot);
      List<Car> carList = new ArrayList<>();
      for (int count=0;count<6;count++){
          carList.add(new Car(""+count));
      }
      Car car = new Car("A001");
      doReturn(carList).when(parkingLot).getParkedCars();
      doReturn(true).when(vipParkingStrategy).isAllowOverPark(car);
      Receipt receipt = vipParkingStrategy.park(parkingLotList,car);

      verify(vipParkingStrategy,times(1)).createReceipt(parkingLot,car);
      assertEquals("KFC",receipt.getParkingLotName());
      assertEquals("A001",receipt.getCarName());

  }

  @Test
  public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {

    /* Exercise 4, Write a test case on VipParkingStrategy.park()
     * With using Mockito spy, verify and doReturn */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue() {

    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse() {

    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  @Test
  public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
    /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
     * You may refactor the code, or try to use
     * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
     */
  }

  private Car createMockCar(String carName) {
    Car car = mock(Car.class);
    when(car.getName()).thenReturn(carName);
    return car;
  }
}
